# campushub-config - Service de Configuration (Spring Cloud Config)

Ce service est le serveur de configuration centralisé de l'architecture microservices Campushub. Il fournit une gestion externe et dynamique des propriétés de configuration pour toutes les autres applications de l'écosystème Campushub.

Il utilise Spring Cloud Config Server et récupère ses configurations depuis le dépôt Git `https://github.com/campushub-org/campushub-cloud-config.git` (ou sa version locale).

### Fonctionnalités

*   **Centralisation des configurations**: Toutes les configurations des services sont gérées à un seul endroit.
*   **Actualisation dynamique**: Les changements de configuration peuvent être rechargés par les services sans redémarrage complet (si configuré).
*   **Séparation Code/Config**: Permet de déployer le même code dans différents environnements avec des configurations distinctes.

### Comment ça marche

Le service `campushub-config` est une application Spring Boot. Lors de son démarrage, il se connecte au dépôt Git spécifié pour y charger les fichiers de propriétés (par exemple, `application.properties`, `campushub-user-service.properties`, etc.). Les autres microservices se connectent à ce service de configuration pour obtenir leurs propriétés au démarrage.

### Commandes Utiles

#### Construire le service (localement, sans Docker)

Pour construire le fichier JAR exécutable du service:

```bash
cd campushub-deployment/campushub-config
./mvnw clean install
```

#### Exécuter le service (localement, sans Docker)

Assurez-vous d'avoir construit le JAR au préalable.

```bash
cd campushub-deployment/campushub-config
java -jar target/campushub-config-service.jar
```

Le service sera accessible sur `http://localhost:8888`.

#### Construire et exécuter avec Docker Compose

Dans le répertoire `campushub-deployment`, ce service est défini dans le fichier `docker-compose.yml`.

Pour construire l'image Docker (cela inclut la construction du JAR si ce n'est pas déjà fait):

```bash
cd campushub-deployment
docker-compose build campushub-config
```

Pour démarrer le conteneur du service (assurez-vous que le JAR a été construit ou utilisez `docker-compose up --build`):

```bash
cd campushub-deployment
docker-compose up -d campushub-config
```

Pour vérifier les logs du service une fois démarré:

```bash
cd campushub-deployment
docker-compose logs campushub-config
```
