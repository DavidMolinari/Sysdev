## Procédure


Les environnement système au CNAM nous permettant pas d'installer des librairies indispensables nous avons du nous débrouiller autrement

- Installation d'une machine virtuelle "Debian" sous VIRTUALBOX
  ![JVM](./assets/JVM.PNG)
- Installations de packages LAMP ( apache mysql php )

  ![JVM](./assets/PHP.PNG)
- Mise en réseau de la machine virtuelle sur le réseau avec comme addresse ip : **10.21.99.68** 

  ![JVM](./assets/IP.PNG)
- Création d'une database pour les tests

  ![JVM](./assets/DB.PNG)
- gestion des accès en db pour se connecter depuis l'exterieur


# Pour un fonctionnement depuis un système linux limité ( Pas de sudo ) il faut :
  - Télécharger le [MysqlConnector](https://github.com/DavidMolinari/Sysdev/blob/master/J/JDBC/mysql-connector-java-5.1.42.jar) qui permet de de faire le lien entre JDBC & MYSQL
  - Exécuter la classe Java en redéfinissant le classpath avec le jar téléchargé précédement
  ```bash 
  java -classpath :./mysql-connector-java-5.1.42.jar jdbc
  ```



