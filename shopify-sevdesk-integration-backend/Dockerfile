# Stage 1: Build the Spring Boot application
FROM gradle:8.8.0-jdk22 AS build
WORKDIR /app

# Kopieren Sie die Gradle-Konfigurationsdateien
COPY build.gradle.kts settings.gradle.kts ./

# Kopieren Sie die restlichen Projektdateien
COPY src ./src

# Führen Sie den Gradle-Build aus und überspringen Sie die Tests
RUN gradle build -x test

# Zeigen Sie den Inhalt des Verzeichnisses an, um sicherzustellen, dass das Build-Verzeichnis vorhanden ist
RUN ls -la /app/build/libs

# Stage 2: Run the Spring Boot application
FROM openjdk:22-ea
WORKDIR /app

# Kopieren Sie die erstellte JAR-Datei aus dem Build-Container
COPY --from=build /app/build/libs/*-SNAPSHOT.jar ./app.jar

# Kopieren Sie das wait-for-it.sh Skript aus dem Build-Container
COPY wait-for-it.sh ./wait-for-it.sh

# Make the wait-for-it.sh script executable
RUN chmod +x ./wait-for-it.sh

# Setzen Sie den Entry-Point auf das Ausführen der JAR-Datei mit wait-for-it.sh
ENTRYPOINT ["./wait-for-it.sh", "db:3306", "--", "java", "-jar", "app.jar"]
