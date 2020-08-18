# Build
FROM maven:3.6-openjdk-14-slim as build
WORKDIR /app
COPY pom.xml .
COPY . ./
RUN mvn package

# Application
FROM openjdk:14-alpine

ENV JAVA_ENV=PRODUCTION
ENV KUMULUZEE_ENV_NAME=prod
ENV KUMULUZEE_ENV_PROD=true
ENV KUMULUZEE_LOGS_LOGGERS0_LEVEL=INFO
ENV MONGO_USERNAME=mongo
ENV MONGO_PASSWORD=mongo
ENV MONGO_HOST=localhost
ENV MONGO_PORT=27017
ENV MONGO_DATABASE=supervisor

COPY --from=build /app/api/v1/target/pinger-supervisor.jar /app/api/v1/target/pinger-supervisor.jar

ENTRYPOINT ["java", "-jar"]
CMD ["/app/api/v1/target/pinger-supervisor.jar"]