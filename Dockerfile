FROM eclipse-temurin:21-jdk-jammy
# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file from your `target` directory into the container
# The JAR file is renamed to app.jar for simplicity and consistency.
COPY target/*.jar app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# The command to run your application
ENTRYPOINT ["java", "-jar", "app.jar"]