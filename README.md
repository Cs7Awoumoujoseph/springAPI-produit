# Spring API Produit

## Présentation

**Spring API Produit** est une API REST Java basée sur Spring Boot pour gérer des produits et leurs catégories. Le projet utilise Spring Data JPA pour la persistance et PostgreSQL comme base de données.

L'application expose son API sous le chemin de contexte `/produits` et utilise le port `8080` par défaut (ou la valeur fournie par la variable `PORT`).

## Technologies

- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA et Spring Data REST
- PostgreSQL
- Maven Wrapper
- Docker

## Organisation du code

```text
springAPI-produit/
├── src/main/java/com/natdhem/produits/
│   ├── RESTController/  # Contrôleurs REST
│   ├── Repository/      # Accès aux données
│   ├── entities/        # Entités Produit et Categorie
│   └── service/         # Logique métier
├── src/main/resources/
│   └── application.properties
├── mvnw
├── mvnw.cmd
├── pom.xml
└── Dockerfile
```

## Prérequis

- JDK 17.
- PostgreSQL.
- Git, si vous clonez le dépôt.
- Docker, uniquement si vous souhaitez construire et exécuter l'image conteneurisée.

## Configuration

La configuration de la base de données se fait par variables d'environnement :

| Variable | Rôle |
|---|---|
| `DB_URL` | URL JDBC de PostgreSQL |
| `DB_USERNAME` | Nom d'utilisateur PostgreSQL |
| `DB_PASSWORD` | Mot de passe PostgreSQL |
| `PORT` | Port HTTP, facultatif (8080 par défaut) |

Exemple de configuration locale à adapter à votre environnement :

```bash
export DB_URL='jdbc:postgresql://localhost:5432/produits'
export DB_USERNAME='votre_utilisateur'
export DB_PASSWORD='votre_mot_de_passe'
export PORT=8080
```

Sous Windows PowerShell, utilisez `$env:DB_URL`, `$env:DB_USERNAME`, `$env:DB_PASSWORD` et `$env:PORT`.

Créez au préalable la base de données PostgreSQL correspondante. Hibernate est configuré avec `ddl-auto=update), ce qui peut modifier le schéma au démarrage ; en production, préférez une stratégie de migrations contrôlées.

## Installation et lancement

Clonez le projet :

```bash
git clone https://github.com/Cs7Awoumoujoseph/springAPI-produit.git
cd springAPI-produit
```

Lancez l'application avec le Maven Wrapper :

Sur Linux/macOS :

```bash
./mvnw spring-boot:run
```

Sur Windows :

```bat
mvnw.cmd spring-boot:run
```

Pour compiler le projet :

```bash
./mvnw clean package
```

L'API sera disponible sur `http://localhost:8080/produits`, sous réserve que la base de données soit accessible et que la configuration soit correcte.

## Docker

Le dépôt fournit un `Dockerfile` multi-étapes qui compile le projet avec Maven et l'exécute sur Java 17. Après avoir préparé les variables d'environnement et l'accès à PostgreSQL, construisez l'image :

```bash
docker build -t spring-api-produit .
```

Puis lancez le conteneur en lui transmettant les variables requises :

```bash
docker run --rm -p 8080:8080 \
  -e DB_URL='jdbc:postgresql://host.docker.internal:5432/produits' \
  -e DB_USERNAME='votre_utilisateur' \
  -e DB_PASSWORD='votre_mot_de_passe' \
  spring-api-produit
```

Adaptez l'hôte de la base de données à votre réseau Docker. Ne placez pas de vrais secrets dans le dépôt ni dans une image publiée.

## Endpoints

Les contrôleurs sont regroupés dans `RESTController`. Consultez `ProduitRESTController.java` et la configuration Spring Data REST pour connaître les routes exactes disponibles dans la version courante.

## Points d'attention

- Les variables de connexion à PostgreSQL sont attendues dans l'environnement ; configurez-les avant de démarrer.
- Les routes et les formats JSON doivent être vérifiés dans les contrôleurs avant d'intégrer l'API à un client.
- Ajoutez ou complétez les tests automatisés et documentez les exemples de requêtes/réponses.
- En production, désactivez l'affichage détaillé des requêtes SQL si celui-ci expose des informations inutiles.

## Licence

Aucune licence explicite n'est identifiée dans le dépôt. Ajoutez une licence si vous souhaitez préciser les conditions de réutilisation.
