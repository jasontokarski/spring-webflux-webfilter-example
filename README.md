# WebFlux WebFilter and Controller Logging Application

This Spring Boot application demonstrates the use of WebFlux to create a WebFilter and a Controller. The application includes an endpoint `/log` that logs the body of incoming requests.

## Features

- **WebFlux WebFilter**: Intercepts HTTP requests and logs request details.
- **Controller**: Handles requests to `/log` and logs the body of the request.
- **Gradle Build**: Uses Gradle for building the project.
- **Spring Boot**: Runs as a Spring Boot application.

## Requirements

- Java 11 or later
- Gradle 6.0 or later

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/jasontokarski/spring-webflux-webfilter-example.git
cd spring-webflux-webfilter-example
```

### Build the Project
./gradlew build

### Run the Application
java -jar build/libs/filter-0.0.1-SNAPSHOT.jar
