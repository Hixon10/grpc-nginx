FROM openjdk:8

RUN mkdir -p /movie/

COPY . /movie

WORKDIR /movie

RUN chmod 777 /movie/gradlew

RUN ./gradlew test build

CMD ["./gradlew", "bootRun"]

EXPOSE 6565