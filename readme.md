### Installation

1. Version Java utilisée: 17

2. faire un clone du repertoire du projet:

```sh
   git clone https://github.com/RichardMargin/SoapRest.git
```

3. le port du server spécifié dans le projet: 9090.

4. Pour ce projet, nous utilisons une base de données MySql sur le port 3306 et la base de données utilisée s'appelle "hopital"

5. Lorsqu'un rendez-vous est créé, une consultation associée est automatiquement créée.

6. Lorsqu'un rendez-vous est supprimé, la consultation associée est également supprimée pour garder une cohérence de donnée.

7. Nous avons mis en place des tests unitaires pour assurer la résilliance de notre application.

8. Dans le dossier conception, vous trouvez les 3 diagrammes qui composent notre dossier d'architecture.

9. Les services sont testables sur PostMan (localhost:9090)

10. Nous avons inclus dans le dossier "collection_postman" une collection postman incluant l'enssemble des requêtes http sur les endpoints de notre application.

11. Membres du groupe:

- Sarah ROUINI.
- Walid REHIOUI.
- Mohamed DESOKI.
- Richard MANGIN.
