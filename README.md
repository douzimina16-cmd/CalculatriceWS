# CalculatriceWS

Service web SOAP en Java exposant une calculatrice (somme, soustraction, multiplication, division), réalisé avec Jakarta XML Web Services (JAX-WS) et Maven.

## Objectifs du TP

- Créer un service web SOAP avec Jakarta XML Web Services
- Découvrir la structure de données générée (WSDL / XSD)
- Annoter le code (`@WebService`, `@WebMethod`, `@WebParam`)
- Publier le service avec `Endpoint.publish`
- Tester les opérations avec SoapUI

## Prérequis

- JDK 21
- Maven
- IntelliJ IDEA
- SoapUI

## Structure du projet

```
CalculatriceWS
├── pom.xml
└── src
    └── main
        └── java
            ├── service
            │   ├── ICalculatrice.java   (interface annotée du service)
            │   └── Calculatrice.java    (implémentation métier)
            └── serveur
                └── ServeurJWS.java      (publication du service)
```

## Dépendances Maven

- `jakarta.xml.ws:jakarta.xml.ws-api` : interfaces JAX-WS (`Endpoint`)
- `com.sun.xml.ws:jaxws-rt` : implémentation pour exécuter le service
- `jakarta.jws:jakarta.jws-api` : annotations du service

## Opérations exposées

| Opération        | Paramètres | Description              |
|------------------|------------|--------------------------|
| `somme`          | `a`, `b`   | Retourne `a + b`         |
| `soustraction`   | `a`, `b`   | Retourne `a - b`         |
| `multiplication` | `a`, `b`   | Retourne `a * b`         |
| `division`       | `a`, `b`   | Retourne `a / b` (erreur si `b = 0`) |

## Lancer le service

1. Ouvrir le projet dans IntelliJ et recharger le projet Maven.
2. Exécuter la classe `serveur.ServeurJWS` (clic droit → *Run*).
3. Le service est publié à l'adresse : `http://localhost:8080/calculatrice`
4. Le WSDL est disponible à : `http://localhost:8080/calculatrice?wsdl`

## Tester avec SoapUI

1. Lancer SoapUI puis *File → New SOAP Project*.
2. Renseigner l'URL du WSDL : `http://localhost:8080/calculatrice?wsdl`
3. Ouvrir la requête de l'opération souhaitée (ex. `somme`).
4. Remplacer les `?` par des valeurs, par exemple :

```xml
<ser:somme>
   <a>10</a>
   <b>5</b>
</ser:somme>
```

5. Exécuter la requête (bouton ▶) et vérifier la réponse :

```xml
<return>15.0</return>
```

## Gestion des erreurs

La division par zéro lève une exception, renvoyée au client sous forme de SOAP Fault.

## Auteur
Ameni Douzi
Projet réalisé dans le cadre d'un TP individuel.
