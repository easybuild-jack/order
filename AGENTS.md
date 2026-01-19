# AGENTS.md

This document provides guidelines for agentic coding agents working in this repository.

## Project Overview

This is a **Gradle-based Java 21** multi-module order management system using Spring Boot, Lombok, and MapStruct Plus. The project follows a layered architecture with API, server, remote (Dubbo/Cloud), and presentation (PRD) modules.

## Build Commands

### Gradle Setup
```bash
gradle build              # Build all modules
gradle clean              # Clean build artifacts
gradle clean build        # Clean and rebuild
gradle test               # Run all tests
gradle :order-server:build # Build specific module
gradle tasks              # List available tasks
```

### Single Module Commands
```bash
gradle :order-api:build
gradle :order-server:build
gradle :order-remote:order-dubbo-provider:build
gradle :order-prd:order-prd-client:build
```

### Publishing
```bash
gradle publish            # Publish to Maven repository (configured in build.gradle)
```

## Code Style Guidelines

### Java Version and Encoding
- Target Java 21 (JavaVersion.VERSION_21)
- All source files must use UTF-8 encoding

### Naming Conventions
- **Interfaces**: Prefix with `I` (e.g., `IOrderInfoService`, `IOrderInfoApi`)
- **DTOs**: Suffix with `Dto` (e.g., `OrderInfoDto`, `OrderPickupDto`)
- **Requests**: Suffix with `Req` (e.g., `OrderInfoReq`, `OrderPickupReq`)
- **Responses**: Suffix with `Resp` (e.g., `OrderInfoResp`, `OrderPickupResp`)
- **Parameters**: Suffix with `Param` (e.g., `OrderInfoParam`, `OrderPickupParam`)
- **Services**: Interface in `service/` package, implementation in `impl/` package
- **Controllers**: `*Controller.java` in controller package
- **Enums**: Suffix with `Enum` (e.g., `OrderStatusEnum`, `RefundStatusEnum`)
- **Packages**: Use lowercase with dots (e.g., `com.mcst.order.api.dto`)

### Package Structure
```
com.mcst.order.api           - API interfaces and DTOs
com.mcst.order.api.request   - Request objects
com.mcst.order.api.response  - Response objects
com.mcst.order.api.dto       - Data transfer objects
com.mcst.order.api.param     - Parameter objects
com.mcst.order.api.enums     - Enumerations
com.mcst.order.server.service    - Service interfaces
com.mcst.order.server.impl       - Service implementations
com.mcst.order.server.config     - Configuration classes
com.mcst.order.controller        - REST controllers
com.mcst.order.remote            - Remote service interfaces
com.mcst.order.remote.provider   - Remote service providers
```

### Annotations and Lombok
Use the following annotations consistently:
```java
@Data                          // Generates getters/setters
@EqualsAndHashCode(callSuper = true)  // Includes parent class fields
@Accessors(chain = true)       // Enables fluent setter chaining
@Schema(description = "...")   // Swagger/OpenAPI documentation
@AutoMapper(target = Xxx.class) // MapStruct Plus auto-mapping
@PrimaryKey                    // Entity primary key (from easyfk-core)
```

### Imports Organization
Group imports in this order:
1. `java.*` standard library
2. `javax.*` / `jakarta.*` APIs
3. External dependencies (Spring, Lombok, MapStruct, etc.)
4. Internal project imports (grouped by module)
5. Framework base classes (com.mcst.easyfk.*)

### Class Documentation
Every class should have a JavaDoc header:
```java
/**
 * <p>
 * Brief description of the class
 * </p>
 *
 * @author Author Name
 * @since YYYY-MM-DD
 */
```

### Field Documentation
Document each field with `@Schema` annotation and inline comments for complex fields:
```java
/**
 * Field description
 */
@Schema(description = "字段描述")
private String fieldName;
```

### Error Handling
- Use checked exceptions for business logic errors
- Extend base exception classes from `com.mcst.easyfk.core.exception`
- Return meaningful error codes and messages
- Use `@RestControllerAdvice` for global exception handling

### Testing
- Test classes should be in `src/test/java/` with `*Test.java` naming
- Use JUnit 5 and AssertJ for assertions
- Follow given-when-then structure
- Mock external dependencies with Mockito

### SQL Files
- Place SQL scripts in `sql/` directory
- Use meaningful file names with version or feature prefixes
- Include migration scripts and seed data as needed

### Git Commits
- Write commit messages in Chinese or English consistently
- Include ticket/issue reference if applicable
- Use conventional commit format: `type(scope): description`

## Module Dependencies
```
order-api (shared DTOs, enums, interfaces)
    ↓
order-server (business logic, services)
    ↓
order-remote (Dubbo/Cloud providers)
    ↓
order-prd (REST controllers - client, bms)
```

## Key Dependencies
- Spring Boot 3.2.12
- Lombok 1.18.38
- MapStruct Plus 1.5.0
- EasyFK framework (custom internal framework)

## IDE Configuration
- **IntelliJ IDEA**: Import as Gradle project, enable annotation processing
- **Eclipse**: Use `.classpath` and `.settings` configurations provided
- **VS Code**: Use settings in `.vscode/` if present
