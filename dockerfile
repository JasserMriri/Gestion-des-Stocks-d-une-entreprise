FROM openjdk:17

EXPOSE 8084
ADD target/ProdouiH-0.0.1-SNAPSHOT.jar produit.jar
ENTRYPOINT ["java", "-jar", "produit.jar"]

