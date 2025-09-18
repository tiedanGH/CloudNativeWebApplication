# WebApplication (Assignment 1)
This project is based on Spring Boot and built using Gradle. Provide build and run methods for the Ubuntu system.

## Feature
- Health Check Endpoint: GET /healthz

## Build and Run (Ubuntu)
1. Install MySQL、OpenJDK 17、Gradle
    ```bash
    sudo apt update
    sudo apt install -y mysql-server openjdk-17-jdk gradle
    ```

2. Set environment variables (optional: SERVER_PORT)
    ```bash
    export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/database?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true
    export SPRING_DATASOURCE_USERNAME=user
    export SPRING_DATASOURCE_PASSWORD=password
    export SERVER_PORT=8080
    ```

3. Build and run
    ```bash
   ./gradlew build
   java -jar build/libs/CloudNativeWebApplication-v0.0.1.jar
    ```

## Testing
- Testing Health Check Endpoint
   ```bash
   curl -vvvv http://localhost:8080/healthz
   ```
- 405 Method Not Allowed
   ```bash
   curl -vvvv -XPUT http://localhost:8080/healthz  
   ```
