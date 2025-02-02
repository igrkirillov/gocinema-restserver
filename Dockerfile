FROM openjdk:23
COPY build/libs/*.jar gocinema-server.jar
ENTRYPOINT ["java","-jar","/gocinema-server.jar"]