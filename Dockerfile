FROM openjdk:21-jdk
VOLUME /tmp
COPY target/pmu_horse_racing-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
