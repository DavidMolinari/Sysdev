# TP1

I. Principes de base de java RMI

a) On veut mettre en place avec RMI un objet proposant la méthode distribuée de signature suivante : 
int m (P p) {…}.
Cette méthode est implémentée dans une classe C et sa signature est définie dans une interface I. Indiquer les caractéristiques de la méthode m, de l'interface I, de la classe C, de la classe P (le paramètre p est transmis par copie du client vers le serveur) en terme d'héritage, d'implémentation d'interface(s) et/ou de levée(s) d'exception(s)). Et si p est transmis par référence ?

### 

b) Avant de pouvoir appeler les méthodes d'un objet distant, le client doit disposer de l'objet stub correspondant. Où le trouve t-il et comment le récupère t-il ? Et la classe stub, où le client la trouve t-il et/ou comment la récupère t-il ? 

### 



II.

a) De quel côté (client ou serveur) doit-on placer ces différentes interfaces et classes (une fois compilées). A quoi correspond chacune ? Que manque t-il et comment l'obtient-t-on ? Qu'est ce qui est affiché par le client ?

- Client : 
  - PetitClient.java
  - TraitementsInterface.java
  - Personne.java
- Serveur : 
  - Traitements.java
  - PetitServeur.java

Il manque : 
```meh  MEH ```


Le client affiche : 

```bash
Luke Lucky a 30ans
```
b) Que doit-on modifier dans le code des classes et interfaces précédentes pour que le paramètre objet soit maintenant passé par adresse. Comment doit-on maintenant répartir les différentes classes et interfaces entre le client et le serveur. 

```java
  System.out.println("Meh");
```


Qu'est ce qui est maintenant affiché par le client ?

```bash
Meh
```
