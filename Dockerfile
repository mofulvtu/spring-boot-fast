FROM ascdc/jdk8
VOLUME /tmp
COPY target/spring-boot-fast-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
