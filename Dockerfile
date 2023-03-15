FROM openjdk:17.0.2
WORKDIR /app-api
COPY build/libs/finalProject-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar","/finalProject-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080

