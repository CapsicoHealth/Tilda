# Tilda Modular Build System

## 🎯 **Overview**

This document describes the new modular Gradle build system for Tilda, designed to address Laurent's feedback about the "ONE mega-build" approach. The system provides:

- **Modular Dependencies**: Choose only the database/cloud providers you need
- **Faster Builds**: Compile only the modules you're using
- **Better Organization**: Clear separation of concerns
- **Easier Testing**: Test individual components in isolation
- **Flexible Deployment**: Deploy specific functionality as needed

## 📁 **Module Structure**

### **Core Modules**
```
tilda-core/          # Base classes, utilities, data access layer
tilda-antlr/         # Grammar parsing and code generation
```

### **Database Modules**
```
tilda-postgres/      # PostgreSQL database support
tilda-sqlserver/     # Microsoft SQL Server support  
tilda-bigquery/      # Google BigQuery support
```

### **Cloud Modules**
```
tilda-gcp/           # Google Cloud Platform integration
```

### **Utility Modules**
```
tilda-cli/           # Command line interface
tilda-export/        # Data export/import utilities
tilda-migration/     # Database migration tools
tilda-web/           # Web interface and servlet support
```

## 🚀 **Quick Start**

### **1. Build Everything**
```bash
./gradlew build
```

### **2. Build Specific Module**
```bash
./gradlew :tilda-core:build
./gradlew :tilda-postgres:build
```

### **3. Run Tilda Tasks**
```bash
# Generate code from schemas
./gradlew generateCode -PschemaPath=/path/to/schema.json

# Export data
./gradlew exportData -PexportConfig=/path/to/config.json

# Run migrations
./gradlew migrate -PmigrationConfig=/path/to/config.json
```

## 📋 **Available Tasks**

### **Tilda-Specific Tasks**
```bash
./gradlew tasks --group=tilda
```

**Core Tasks:**
- `generateCode` - Generate Tilda code from JSON schemas
- `exportData` - Export data using Tilda export utility
- `migrate` - Run Tilda database migrations

**Export Tasks:**
- `exportToCsv` - Export data to CSV format
- `exportToJson` - Export data to JSON format  
- `exportToBigQuery` - Export data to BigQuery

**Migration Tasks:**
- `migrationStatus` - Check migration status
- `migrationPlan` - Generate migration plan
- `rollback` - Rollback last migration

### **Standard Gradle Tasks**
```bash
# Build all modules
./gradlew build

# Run tests
./gradlew test

# Clean build artifacts
./gradlew clean

# Generate documentation
./gradlew javadoc

# Publish to local repository
./gradlew publishToMavenLocal
```

## 🔧 **Module Dependencies**

### **Dependency Graph**
```
tilda-core (base)
├── tilda-antlr
├── tilda-postgres → tilda-core
├── tilda-sqlserver → tilda-core
├── tilda-bigquery → tilda-core
├── tilda-gcp → tilda-core + tilda-bigquery
├── tilda-cli → tilda-core + tilda-antlr
├── tilda-export → tilda-core
├── tilda-migration → tilda-core
└── tilda-web → tilda-core
```

### **Choosing Your Dependencies**

**For PostgreSQL-only projects:**
```gradle
dependencies {
    implementation 'com.capsico.tilda:tilda-core:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-postgres:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-cli:2.5.2-SNAPSHOT'
}
```

**For BigQuery + GCP projects:**
```gradle
dependencies {
    implementation 'com.capsico.tilda:tilda-core:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-bigquery:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-gcp:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-export:2.5.2-SNAPSHOT'
}
```

**For full-stack web applications:**
```gradle
dependencies {
    implementation 'com.capsico.tilda:tilda-core:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-postgres:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-web:2.5.2-SNAPSHOT'
    implementation 'com.capsico.tilda:tilda-migration:2.5.2-SNAPSHOT'
}
```

## 🏗️ **Build Profiles**

### **Development Profile** (default)
- Includes all modules for development convenience
- Fast compilation with parallel builds
- Comprehensive testing

### **Production Profiles**
Create custom build configurations for specific deployments:

**Minimal CLI:**
```bash
./gradlew :tilda-core:build :tilda-cli:build
```

**Database Migration Only:**
```bash
./gradlew :tilda-core:build :tilda-postgres:build :tilda-migration:build
```

**BigQuery Export Service:**
```bash
./gradlew :tilda-core:build :tilda-bigquery:build :tilda-gcp:build :tilda-export:build
```

## 📦 **Packaging Options**

### **Individual JARs**
Each module produces its own JAR:
```
modules/tilda-core/build/libs/tilda-core-2.5.2-SNAPSHOT.jar
modules/tilda-postgres/build/libs/tilda-postgres-2.5.2-SNAPSHOT.jar
```

### **Fat JARs** (Standalone Executables)
```bash
# CLI with all dependencies
./gradlew :tilda-cli:fatJar

# Export utility with all dependencies  
./gradlew :tilda-export:fatJar
```

### **WAR Files** (Web Deployment)
```bash
./gradlew :tilda-web:war
```

## 🔄 **Migration from Legacy Build**

### **Current State**
- All source code in `src/` directory
- All dependencies in single classpath
- Single JAR output

### **Migration Strategy**

**Phase 1: Parallel Build Systems**
- Keep existing build scripts working
- Add modular Gradle build alongside
- Test modular build with existing code structure

**Phase 2: Gradual Migration**
- Move database-specific code to modules
- Update import statements
- Migrate tests module by module

**Phase 3: Full Migration**
- Remove legacy build scripts
- Reorganize source code into module directories
- Update documentation and examples

### **Backward Compatibility**
The modular build system maintains full backward compatibility:
- Existing source code structure works unchanged
- All existing functionality preserved
- Legacy scripts continue to work during transition

## 🧪 **Testing Strategy**

### **Unit Tests per Module**
```bash
# Test specific module
./gradlew :tilda-postgres:test

# Test all modules
./gradlew test
```

### **Integration Tests**
```bash
# Test cross-module functionality
./gradlew integrationTest
```

### **Database-Specific Testing**
```bash
# Test PostgreSQL functionality
./gradlew :tilda-postgres:test

# Test BigQuery functionality  
./gradlew :tilda-bigquery:test
```

## 📊 **Performance Benefits**

### **Build Time Improvements**
- **Incremental Builds**: Only rebuild changed modules
- **Parallel Compilation**: Multiple modules compile simultaneously
- **Selective Building**: Build only what you need

### **Runtime Benefits**
- **Smaller JARs**: Include only required dependencies
- **Faster Startup**: Reduced classpath scanning
- **Memory Efficiency**: Load only needed components

### **Development Benefits**
- **Faster Tests**: Test individual modules in isolation
- **Clear Dependencies**: Explicit module relationships
- **Better IDE Support**: Improved code navigation and completion

## 🔧 **Configuration**

### **Gradle Properties**
Edit `gradle.properties` to customize build behavior:
```properties
# Performance tuning
org.gradle.parallel=true
org.gradle.caching=true
org.gradle.jvmargs=-Xmx2g

# Module selection (example)
tilda.modules.postgres=true
tilda.modules.bigquery=false
tilda.modules.gcp=false
```

### **Environment-Specific Builds**
```bash
# Development build (all modules)
./gradlew build -Pprofile=dev

# Production build (minimal modules)
./gradlew build -Pprofile=prod

# Cloud build (BigQuery + GCP)
./gradlew build -Pprofile=cloud
```

## 🚀 **Next Steps**

### **Immediate (Week 1)**
1. ✅ **Modular build system created**
2. ✅ **Gradle wrapper configured**
3. ✅ **All modules defined with dependencies**
4. 🔄 **Test basic build functionality**

### **Short Term (Weeks 2-4)**
1. **Source Code Migration**: Move database-specific code to modules
2. **Enhanced CLI**: Integrate modular build with CLI scripts
3. **Docker Integration**: Create module-specific containers
4. **CI/CD Pipeline**: Set up automated builds per module

### **Medium Term (Months 2-3)**
1. **Performance Optimization**: Fine-tune build performance
2. **Plugin Development**: Create Gradle plugins for Tilda-specific tasks
3. **IDE Integration**: Enhance IntelliJ/Eclipse project structure
4. **Documentation**: Complete migration guides and examples

## 📞 **Support**

For questions about the modular build system:
1. Check this documentation first
2. Run `./gradlew help --task <taskname>` for task-specific help
3. Review build logs in `build/reports/` directories
4. Create issues for bugs or enhancement requests

---

**This modular build system addresses Laurent's feedback about the "mega-build" approach while maintaining full backward compatibility and providing a clear migration path.**
