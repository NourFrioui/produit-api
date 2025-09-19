# Stock Management System

## Description

Le **Stock Management System** est une application web développée avec Spring Boot qui permet de gérer un système de gestion de stock complet. Cette application offre une API REST complète pour la gestion des produits, commandes, paiements, expéditions et profils utilisateurs.

## Architecture

L'application suit une architecture en couches (Layered Architecture) avec les composants suivants :

- **Controllers** : Couche de présentation qui expose les endpoints REST API
- **Services** : Couche métier contenant la logique d'application
- **Repositories** : Couche d'accès aux données utilisant Spring Data JPA
- **Entities** : Modèles de données représentant les tables de base de données
- **DTOs** : Objets de transfert de données pour les requêtes API

## Modèle de Données

### Entités Principales

#### 1. **Person** (Personne)

- Représente les utilisateurs du système
- Champs : nom, prénom, email, etc.
- Relations : Un-à-plusieurs avec Address, Order, Profile

#### 2. **Product** (Produit)

- Représente les produits en stock
- Champs : nom, prix, description
- Relations : Plusieurs-à-plusieurs avec Category, Un-à-plusieurs avec ProductDetail

#### 3. **Category** (Catégorie)

- Classification des produits
- Relations : Plusieurs-à-plusieurs avec Product

#### 4. **Order** (Commande)

- Commandes passées par les clients
- Champs : date de commande
- Relations : Plusieurs-à-un avec Person, Un-à-plusieurs avec OrderItem, Payment, Shipment

#### 5. **OrderItem** (Article de Commande)

- Articles individuels dans une commande
- Champs : quantité
- Relations : Plusieurs-à-un avec Order et Product

#### 6. **Payment** (Paiement)

- Informations de paiement des commandes
- Champs : type de paiement, montant
- Relations : Plusieurs-à-un avec Order

#### 7. **Shipment** (Expédition)

- Informations d'expédition des commandes
- Champs : numéro de suivi, statut, date d'expédition
- Relations : Plusieurs-à-un avec Order

#### 8. **Profile** (Profil)

- Profils utilisateur étendus
- Champs : bio, photo de profil
- Relations : Plusieurs-à-un avec Person

#### 9. **Address** (Adresse)

- Adresses des utilisateurs
- Relations : Plusieurs-à-un avec Person

#### 10. **ProductDetail** (Détail Produit)

- Détails supplémentaires des produits
- Relations : Plusieurs-à-un avec Product

## API Endpoints

### Produits (`/api/v1/products`)

- `GET /all` - Récupérer tous les produits
- `GET /{id}` - Récupérer un produit par ID
- `POST /` - Créer un nouveau produit
- `PATCH /{id}` - Mettre à jour un produit
- `DELETE /{id}` - Supprimer un produit

### Commandes (`/api/v1/orders`)

- `GET /all` - Récupérer toutes les commandes
- `GET /{id}` - Récupérer une commande par ID
- `POST /` - Créer une nouvelle commande
- `PATCH /{id}` - Mettre à jour une commande
- `DELETE /{id}` - Supprimer une commande

### Articles de Commande (`/api/v1/order-items`)

- `GET /all` - Récupérer tous les articles de commande
- `GET /{id}` - Récupérer un article par ID
- `POST /` - Créer un nouvel article de commande
- `PATCH /{id}` - Mettre à jour un article
- `DELETE /{id}` - Supprimer un article

### Paiements (`/api/v1/payments`)

- `GET /all` - Récupérer tous les paiements
- `GET /{id}` - Récupérer un paiement par ID
- `POST /` - Créer un nouveau paiement
- `PATCH /{id}` - Mettre à jour un paiement
- `DELETE /{id}` - Supprimer un paiement

### Expéditions (`/api/v1/shipments`)

- `GET /all` - Récupérer toutes les expéditions
- `GET /{id}` - Récupérer une expédition par ID
- `POST /` - Créer une nouvelle expédition
- `PATCH /{id}` - Mettre à jour une expédition
- `DELETE /{id}` - Supprimer une expédition

### Profils (`/api/v1/profiles`)

- `GET /all` - Récupérer tous les profils
- `GET /{id}` - Récupérer un profil par ID
- `POST /` - Créer un nouveau profil
- `PATCH /{id}` - Mettre à jour un profil
- `DELETE /{id}` - Supprimer un profil

### Personnes (`/api/v1/persons`)

- `GET /all` - Récupérer toutes les personnes
- `GET /{id}` - Récupérer une personne par ID
- `POST /` - Créer une nouvelle personne
- `PATCH /{id}` - Mettre à jour une personne
- `DELETE /{id}` - Supprimer une personne

### Catégories (`/api/v1/categories`)

- `GET /all` - Récupérer toutes les catégories
- `GET /{id}` - Récupérer une catégorie par ID
- `POST /` - Créer une nouvelle catégorie
- `PATCH /{id}` - Mettre à jour une catégorie
- `DELETE /{id}` - Supprimer une catégorie

### Adresses (`/api/v1/addresses`)

- `GET /all` - Récupérer toutes les adresses
- `GET /{id}` - Récupérer une adresse par ID
- `POST /` - Créer une nouvelle adresse
- `PATCH /{id}` - Mettre à jour une adresse
- `DELETE /{id}` - Supprimer une adresse

### Détails Produit (`/api/v1/product-details`)

- `GET /all` - Récupérer tous les détails produit
- `GET /{id}` - Récupérer un détail par ID
- `POST /` - Créer un nouveau détail produit
- `PATCH /{id}` - Mettre à jour un détail
- `DELETE /{id}` - Supprimer un détail

## Technologies Utilisées

- **Spring Boot** 3.x - Framework principal
- **Spring Data JPA** - Accès aux données
- **Spring Web** - API REST
- **Lombok** - Réduction du code boilerplate
- **Jakarta Persistence API** - Mapping objet-relationnel
- **Maven** - Gestion des dépendances
- **Docker** - Conteneurisation (avec compose.yaml)

## Configuration

L'application supporte plusieurs profils d'environnement :

- `dev` - Développement
- `test` - Tests
- `uat` - Tests d'acceptation utilisateur
- `prod` - Production

## Installation et Exécution

### Prérequis

- Java 17 ou supérieur
- Maven 3.6+
- Docker (optionnel)

### Exécution locale

```bash
# Cloner le projet
git clone [url-du-repo]
cd stock-management

# Compiler et exécuter
./mvnw spring-boot:run
```

### Exécution avec Docker

```bash
# Construire et lancer avec Docker Compose
docker-compose up --build
```

## Gestion des Erreurs

L'application inclut une gestion globale des erreurs avec :

- `GlobalExceptionHandler` - Gestionnaire global des exceptions
- `NotFoundException` - Exception personnalisée pour les ressources non trouvées
- `ErrorResponse` - Format standardisé des réponses d'erreur

## Structure du Projet

```
src/
├── main/
│   ├── java/
│   │   └── com/springboot_test/stock_management/
│   │       ├── controller/          # Contrôleurs REST
│   │       ├── service/             # Services métier
│   │       ├── repository/          # Repositories JPA
│   │       ├── model/
│   │       │   ├── entity/          # Entités JPA
│   │       │   └── dto/             # Data Transfer Objects
│   │       ├── exceptions/          # Gestion des exceptions
│   │       └── StockManagementApplication.java
│   └── resources/
│       ├── application*.properties  # Configurations par environnement
│       ├── static/                  # Ressources statiques
│       └── templates/               # Templates (si nécessaire)
└── test/                           # Tests unitaires et d'intégration
```

## Fonctionnalités Principales

1. **Gestion des Produits** - CRUD complet pour les produits et leurs catégories
2. **Gestion des Commandes** - Création et suivi des commandes client
3. **Gestion des Paiements** - Traitement et suivi des paiements
4. **Gestion des Expéditions** - Suivi des expéditions avec numéros de tracking
5. **Gestion des Utilisateurs** - Profils utilisateur avec adresses
6. **API REST Complète** - Endpoints pour toutes les opérations CRUD
7. **Gestion d'Erreurs** - Gestion centralisée des erreurs avec messages appropriés

## Contribution

Pour contribuer au projet :

1. Fork le repository
2. Créer une branche feature (`git checkout -b feature/nouvelle-fonctionnalite`)
3. Commit les changes (`git commit -am 'Ajout nouvelle fonctionnalité'`)
4. Push sur la branche (`git push origin feature/nouvelle-fonctionnalite`)
5. Créer une Pull Request

## Licence

Ce projet est sous licence [spécifier la licence].

## Support

Pour toute question ou problème, veuillez ouvrir une issue sur le repository GitHub.
