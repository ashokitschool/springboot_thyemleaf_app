FROM openjdk:8
EXPOSE 8080
ADD target/sb-app.jar sb-app.jar
ENTRYPOINT ["java","-jar","/sb-app.jar"]