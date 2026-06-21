# Travel Expense Tracker 

Application de gestion de voyages et de dépenses, développée dans le cadre d'un projet DevOps.

Elle permet de :
- Ajouter des destinations de voyage et suivre leur statut (à venir, en cours, terminé)
- Organiser des villes et des attractions à visiter dans chaque destination
- Suivre les dépenses (hôtel, transport, restauration, activités, shopping, divers) liées à chaque voyage
- Calculer le total dépensé par destination

## Stack technique

| Élément | Technologie |
|---|---|
| Backend | Java 21, Spring Boot 3.2.0 |
| Persistance | Spring Data JPA / Hibernate |
| Base de données | PostgreSQL en ligne (Neon) — H2 en mémoire par défaut |
| Front | HTML / JS, servi par Nginx |
| Tests | JUnit 5, MockMvc |
| Couverture de code | JaCoCo + Codecov |
| Qualité de code | SonarCloud |
| Conteneurisation | Docker, Docker Compose |
| CI/CD | GitHub Actions |

## Architecture

Le backend suit une architecture en couches classique :

```
Controllers  →  Services  →  Repositories  →  Base de données
(API REST)      (logique)     (Spring Data JPA)
```

Les entités principales sont `Destination`, `City`, `Attraction` et `Expense`.

## Structure du projet

```
travel-expense-tracker/
├── MyService/              # Backend Spring Boot
│   ├── src/main/java/...   # Entities, Services, Controllers, Repositories
│   └── src/test/java/...   # Tests unitaires et MockMvc
├── front/                   # Front (HTML/JS + Nginx)
├── docker-compose.yml       # Lance backend + front ensemble
└── .github/workflows/       # Pipeline CI/CD
```

## Lancer le projet en local

### 1. Configurer la base de données (optionnel)

Par défaut, l'application utilise une base **H2 en mémoire** : aucune configuration n'est nécessaire, mais les données ne sont pas conservées entre deux démarrages.

Pour utiliser une vraie base PostgreSQL (Neon), crée un fichier `.env` à la racine du projet :

```
DATABASE_URL=jdbc:postgresql://<ton-host-neon>/neondb?sslmode=require
DATABASE_USER=<ton-utilisateur>
DATABASE_PASSWORD=<ton-mot-de-passe>
```

> Le fichier `.env` n'est jamais poussé sur GitHub (il est fournit dans le zip du projet avec le rapport).

### 2. Lancer avec Docker

```bash
docker compose up --build
```

- Le backend démarre sur `http://localhost:8080`
- Le front est accessible sur `http://localhost:8081`

Au premier démarrage, un `DataSeeder` remplit automatiquement la base avec des données de démonstration (8 destinations avec villes, attractions et dépenses).

### 3. Lancer sans Docker (backend seul)

```bash
cd MyService
./gradlew bootRun
```

## Lancer les tests

```bash
cd MyService
./gradlew test
```

Le rapport de tests est généré dans `MyService/build/reports/tests/test/index.html`.

Pour générer aussi le rapport de couverture JaCoCo :

```bash
./gradlew test jacocoTestReport
```

Rapport disponible dans `MyService/build/reports/jacoco/test/html/index.html`.

## CI/CD

Chaque push et chaque pull request déclenchent automatiquement, via GitHub Actions :
1. L'exécution des tests avec couverture JaCoCo
2. L'envoi du rapport de couverture à Codecov
3. L'analyse de qualité du code avec SonarCloud
4. La construction de l'image Docker

Une pull request ne peut être fusionnée que si toutes ces étapes sont au vert.

## Liens utiles

- Dépôt GitHub : [github.com/fluffykoo/travel-expense-tracker](https://github.com/fluffykoo/travel-expense-tracker)
- SonarCloud : [sonarcloud.io/project/overview?id=fluffykoo_travel-expense-tracker](https://sonarcloud.io/project/overview?id=fluffykoo_travel-expense-tracker)