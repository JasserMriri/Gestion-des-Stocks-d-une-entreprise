# Utiliser une image de base avec Java (version 17 ou autre)
FROM openjdk:17-jdk-slim

# Spécifier l'emplacement du fichier JAR dans votre projet
ARG JAR_FILE=target/BoutiqueMicroservice-0.0.1-SNAPSHOT.jar

# Copier le fichier JAR dans le conteneur
COPY ${JAR_FILE} app.jar

# Exposer le port 8086 sur lequel votre application fonctionne
EXPOSE 8086

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]
