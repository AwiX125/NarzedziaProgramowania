# Java Order Processing System

A simple Java application using Maven and Docker to manage customers, products, and orders.

## Features

- Manage customers, products, and order data
- Build and dependency management via **Maven**
- Containerized execution via **Docker**

## Prerequisites

- **Java 25+**
- **Maven 3.8+**
- **Docker** (optional, for running containerized)

## Quick Start

### Run locally with Maven

```bash
# Build the project
mvn clean package

# Run the application
java -jar target/*.jar
```
### Maven Commands

| Task | Command |
| :--- | :--- |
| **Check Code Style** | `mvn validate` (runs Checkstyle using `google_checks.xml`) |
| **Generate Javadoc** | `mvn compile` (generates docs in `target/site/apidocs`) |
| **Package Project** | `mvn package` (repackages executable JAR) |

### Run with Docker

```bash
# Build Docker image
docker build -t order-system .

# Run Docker container
docker run --rm order-system
```

## Project Structure

```text
docker/
└── docker-compose.yml
programistyczne/
├── zamowienie.json
└── zamowienie2.json
src/
└── main/
    └── java/
        └── pwr/
            └── edu/
                ├── model/       # Customer, Order, Product entities
                └── Main.java    # Application entry point
```
