FROM openjdk:23
COPY build/libs/*.jar gocinema-server.jar
RUN mkdir -p /posters
COPY example/poster.png /posters
ENTRYPOINT ["java","-jar","/gocinema-server.jar"]