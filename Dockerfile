FROM openjdk:14-alpine

RUN mkdir /app
WORKDIR /app

ENV JAVA_ENV=PRODUCTION
ENV KUMULUZEE_ENV_NAME=prod
ENV KUMULUZEE_ENV_PROD=true
ENV KUMULUZEE_LOGS_LOGGERS0_LEVEL=INFO
ENV MONGO_USERNAME=mongo
ENV MONGO_PASSWORD=mongo
ENV MONGO_HOST=localhost
ENV MONGO_PORT=27017
ENV MONGO_DATABASE=supervisor

COPY /api/v1/target/pinger-supervisor.jar /app/pinger-supervisor.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/pinger-supervisor.jar"]
