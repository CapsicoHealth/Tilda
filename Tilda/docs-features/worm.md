# PostgreSQL WORM Storage Implementation Summary

This document summarizes the strategy for implementing Write-Once-Read-Many (WORM) storage behavior in PostgreSQL, focusing on performance, scalability, and maintainability.

## The Problem

Implement a mechanism in PostgreSQL to prevent `UPDATE` and `DELETE` operations on specific tables, with the flexibility to toggle this behavior on or off based on business requirements.

## The Proposed Solution: Dynamic Trigger-Based Locking

Instead of using complex row-level checks that impact every transaction, we utilize **Statement-Level Triggers** combined with **Dynamic DDL** to achieve WORM status.

### 1. The Strict Blocking Function

This function, when active, immediately raises an exception to block any `UPDATE` or `DELETE` attempt.

```sql
CREATE OR REPLACE FUNCTION enforce_worm_strict()
RETURNS TRIGGER AS $$
BEGIN
    RAISE EXCEPTION 'Table "%" is in WORM mode. Updates and deletes are prohibited.', TG_TABLE_NAME;
END;
$$ LANGUAGE plpgsql;

```

### 2. The Dynamic Management Function

This function allows you to turn WORM behavior on or off for a specific table by creating or dropping the trigger dynamically.

```sql
CREATE OR REPLACE FUNCTION set_table_worm(p_table_name TEXT, p_enable BOOLEAN)
RETURNS VOID AS $$
BEGIN
    IF p_enable THEN
        -- Turn WORM ON: Create the trigger
        EXECUTE format(
            'DROP TRIGGER IF EXISTS trg_worm ON %I; ' ||
            'CREATE TRIGGER trg_worm BEFORE UPDATE OR DELETE ON %I ' ||
            'FOR EACH STATEMENT EXECUTE FUNCTION enforce_worm_strict();',
            p_table_name, p_table_name
        );
        RAISE NOTICE 'WORM enabled for table: %', p_table_name;
    ELSE
        -- Turn WORM OFF: Remove the trigger entirely for zero overhead
        EXECUTE format('DROP TRIGGER IF EXISTS trg_worm ON %I;', p_table_name);
        RAISE NOTICE 'WORM disabled (trigger removed) for table: %', p_table_name;
    END IF;
END;
$$ LANGUAGE plpgsql;

```

## Performance Analysis

| Operation | Performance Impact |
| --- | --- |
| **SELECT** | **Zero impact.** Triggers do not fire on read operations. |
| **INSERT** | **Negligible.** Triggers are defined specifically for updates/deletes. |
| **UPDATE/DELETE (WORM ON)** | **Minimal/Improved.** Operation is aborted instantly at the statement level. |
| **UPDATE/DELETE (WORM OFF)** | **Zero impact.** Since the trigger is dropped, PostgreSQL executes the statement at full native speed. |

## Key Advantages

* **Zero Runtime Overhead:** When WORM is disabled, the database performs exactly as a standard table, with no lingering trigger or metadata lookups.
* **Security:** Requiring DDL permissions (`CREATE/DROP TRIGGER`) to toggle the WORM state ensures that only authorized administrators can modify the protection policy.
* **Scalability:** The approach can be applied easily to dozens of tables using simple PL/pgSQL loops to iterate through table lists.
* **Simplicity:** No need for complex session variables, configuration lookups, or metadata tracking tables during runtime.
