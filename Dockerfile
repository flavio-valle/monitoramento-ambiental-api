FROM eclipse-temurin:17-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/seu-projeto.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
