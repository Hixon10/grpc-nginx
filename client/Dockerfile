FROM openjdk:8

RUN mkdir -p /client/

COPY . /client

WORKDIR /client

RUN chmod 777 /client/gradlew

RUN ./gradlew test build

CMD ["./gradlew", "bootRun"]

EXPOSE 81