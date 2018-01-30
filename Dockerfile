FROM openjdk:8-jdk-alpine
EXPOSE 7777
ADD /target/myspring.jar myspring.jar
ENTRYPOINT ["java","-jar","myspring.jar"]
