FROM openjdk:17.0.2
WORKDIR /app-api
COPY build/libs/finalProject-0.0.1-SNAPSHOT.war ./
ENTRYPOINT ["java","-war","/finalProject-0.0.1-SNAPSHOT.war"]
EXPOSE 8080

