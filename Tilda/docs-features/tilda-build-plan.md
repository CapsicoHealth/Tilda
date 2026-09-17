# Blueprint: Modernizing the TILDA Onboarding and Build Environment

This blueprint describes the architectural corrections needed to reduce the initialization barrier of a TILDA project down to seconds using containerized orchestration and standard automation tools.

---

## 1. Containerized Staging: `docker-compose.yml`

This isolated environment boots an optimized **PostgreSQL 18** instance pre-configured to handle internal TILDA connections out-of-the-box. Save this file to your root project workspace.

```yaml
version: '3.8'

services:
  tilda-postgres:
    image: postgres:18-alpine
    container_name: tilda_postgres_dev
    environment:
      POSTGRES_DB: tilda_dev
      POSTGRES_USER: tilda_user
      POSTGRES_PASSWORD: tilda_password
    ports:
      - "5432:5432"
    volumes:
      - tilda_db_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U tilda_user -d tilda_dev"]
      interval: 5s
      timeout: 5s
      retries: 5

volumes:
  tilda_db_data:
    driver: local
```

---

## 2. Automated Pipelines: Modernized `build.gradle`

Replace custom runtime scripts with native, deterministic Gradle actions. The setup below assumes Java 25 compatibility configurations.

```groovy
plugins {
    id 'java'
    id 'application'
}

group = 'com.yourcompany.app'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.postgresql:postgresql:42.7.2'
    implementation 'com.capsico:tilda-core:2.5.1'
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

task generateTildaModels(type: JavaExec) {
    description = 'Executes the TILDA Model Generator engine to produce compiled Java components and SQL DDL.'
    group = 'build'
    
    classpath = sourceSets.main.runtimeClasspath
    mainClass = 'tilda.generation.Generator'
    
    args = [
        "\${projectDir}/src/main/resources/schemas/", 
        "\${buildDir}/generated-sources/tilda/java"   
    ]
}

compileJava.dependsOn generateTildaModels

sourceSets {
    main {
        java {
            srcDirs += "\${buildDir}/generated-sources/tilda/java"
        }
    }
}
```

---

## 3. Immediate Testing Optimization Pipeline

1. **Boot DB:** Execute `docker-compose up -d` in the project root directory.
2. **Compile Project:** Execute `./gradlew build`. The automated `generateTildaModels` task will ingest the target schema definitions, validate compilation parameters against your official `pgJDBC` connector, and write cleanly mapped entities instantly.
