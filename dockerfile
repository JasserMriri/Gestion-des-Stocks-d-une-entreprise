FROM openjdk:17
EXPOSE 8081
ADD target/ProjetFactures-0.0.1-SNAPSHOT.jar factures.jar
ENTRYPOINT ["java", "-jar", "factures.jar"]

