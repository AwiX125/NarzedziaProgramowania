FROM maven:3.9.12-eclipse-temurin-25
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY programistyczne ./programistyczne
RUN mvn clean package
CMD ["java", "-jar", "target/Lab01-1.0.jar"]