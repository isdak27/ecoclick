FROM amazoncorretto:17-alpine-jdk

COPY ecoclickv2/target/ecoclickv2-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java" ,"-jar","/app.jar"]