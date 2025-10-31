# Microservice de Gestion de Comptes Bancaires

Ce projet est un microservice Spring Boot pour la gestion de comptes bancaires, offrant des opérations CRUD via une API REST.

## Fonctionnalités

- Gestion des comptes bancaires (CRUD)
- Support des formats JSON et XML
- Documentation d'API avec Swagger UI
- Base de données H2 en mémoire avec console d'administration
- Initialisation automatique des données de test

## Prérequis

- Java 17 ou supérieur
- Maven 3.6 ou supérieur

## Installation

1. Cloner le dépôt :
   ```bash
   git clone [URL_DU_DEPOT]
   cd ms-banque
   ```

2. Compiler le projet :
   ```bash
   mvn clean install
   ```

3. Lancer l'application :
   ```bash
   mvn spring-boot:run
   ```

## Accès aux services

- **Application** : http://localhost:8082
- **Console H2** : http://localhost:8082/h2-console
  - URL JDBC : jdbc:h2:mem:banque
  - User Name : sa
  - Password : (laisser vide)
- **Documentation Swagger** : http://localhost:8082/swagger-ui.html
- **API Docs (OpenAPI)** : http://localhost:8082/api-docs

## Points d'API disponibles

- `GET /api/banque/comptes` : Récupérer tous les comptes
- `GET /api/banque/comptes/{id}` : Récupérer un compte par son ID
- `POST /api/banque/comptes` : Créer un nouveau compte
- `PUT /api/banque/comptes/{id}` : Mettre à jour un compte existant
- `DELETE /api/banque/comptes/{id}` : Supprimer un compte

## Format des données

### Exemple de compte (JSON)
```json
{
  "id": 1,
  "solde": 1234.56,
  "dateCreation": "2025-10-30",
  "type": "COURANT"
}
```

### Exemple de compte (XML)
```xml
<Compte>
  <id>1</id>
  <solde>1234.56</solde>
  <dateCreation>2025-10-30</dateCreation>
  <type>COURANT</type>
</Compte>
```

## Tests avec cURL

### Récupérer tous les comptes (JSON)
```bash
curl -X GET "http://localhost:8082/api/banque/comptes" -H "Accept: application/json"
```

### Récupérer un compte par ID (XML)
```bash
curl -X GET "http://localhost:8082/api/banque/comptes/1" -H "Accept: application/xml"
```

### Créer un nouveau compte (JSON)
```bash
curl -X POST "http://localhost:8082/api/banque/comptes" \
  -H "Content-Type: application/json" \
  -d '{"solde": 1000.0, "dateCreation": "2025-10-31", "type": "EPARGNE"}'
```

## Licence

Ce projet est sous licence MIT.
