# Tilda Best Practices

## Prefer views and generated access methods

- Model reusable joins, projected fields, filters and ordering in a Tilda view, and use its generated factory lookup methods to retrieve view data. Check existing views and generated methods before building custom query or data-mapping code.
- Strongly prefer this view pattern over `QueryHelper`. Reserve `QueryHelper` as a last resort for dynamic, complex queries that cannot be captured as a view. Existing factory methods named `LookupWithComplexParams` are examples of complex search patterns, often involving access control.
- Keep authorization explicit and verify that the chosen view and lookup enforce the required scope, ordering and limits; a view is not automatically an authorization policy.

Follow the schema and generation instructions for the project being changed.