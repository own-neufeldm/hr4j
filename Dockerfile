FROM openjdk:17 AS build
WORKDIR /usr/src/hr4j
COPY . .
RUN javac -d bin src/main/java/*/*.java
RUN cd bin && jar --create --file hr4j.jar --main-class hr4j.App */*.class

FROM gcr.io/distroless/java17-debian12 AS run
WORKDIR /usr/bin/hr4j
COPY --from=build /usr/src/hr4j/bin/hr4j.jar .
ENTRYPOINT ["java", "-jar", "hr4j.jar"]
