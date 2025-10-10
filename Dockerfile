# Step 1: Use a Maven image to build your Spring Boot app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Use a smaller image to run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose the port (Render will assign it dynamically)
EXPOSE 8080

# Run your app
ENTRYPOINT ["java", "-jar", "app.jar"]
