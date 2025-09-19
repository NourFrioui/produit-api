FROM eclipse-temurin:17-jdk-alpine
LABEL authors="nour"

WORKDIR /app

COPY target/stock-management.jar ./stock-management.jar

EXPOSE 8082


CMD ["java", "-jar","stock-management.jar"]