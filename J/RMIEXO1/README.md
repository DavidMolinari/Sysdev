# TP1

## I. Principes de base de java RMI

a) On veut mettre en place avec RMI un objet proposant la méthode distribuée de signature suivante : 
int m (P p) {…}.
Cette méthode est implémentée dans une classe C et sa signature est définie dans une interface I. Indiquer les caractéristiques de la méthode m, de l'interface I, de la classe C, de la classe P (le paramètre p est transmis par copie du client vers le serveur) en terme d'héritage, d'implémentation d'interface(s) et/ou de levée(s) d'exception(s)). Et si p est transmis par référence ?

```text
 Sry flemme
```

b) Avant de pouvoir appeler les méthodes d'un objet distant, le client doit disposer de l'objet stub correspondant. Où le trouve t-il et comment le récupère t-il ? Et la classe stub, où le client la trouve t-il et/ou comment la récupère t-il ? 

```text

Sry flemme

```



## II. Java RMI. Passage d'un paramètre objet à une méthode distante par valeur et par adresse

a) De quel côté (client ou serveur) doit-on placer ces différentes interfaces et classes (une fois compilées). A quoi correspond chacune ? Que manque t-il et comment l'obtient-t-on ? Qu'est ce qui est affiché par le client ?

- Client : 
  - TraitementsInterface.java
  - PetitClient.java
  - Personne.java
- Serveur : 
  - TraitementsInterface.java
  - Traitements.java
  - PetitServeur.java
  - Personne.java
Il manque : 
Dans traitement
```java
public void vieillirPersonne(Personne p) throws RemoteException {
    p.vieillir();
    p.afficherAge(); // CETTE LIGNE
 }
```
Le client affiche : 

```bash
Luke Lucky a 30ans
```
b) Que doit-on modifier dans le code des classes et interfaces précédentes pour que le paramètre objet soit maintenant passé par adresse. Comment doit-on maintenant répartir les différentes classes et interfaces entre le client et le serveur. 

 - Il faut modifier Personne et Créer son interface
```java
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
class Personne extends UnicastRemoteObject implements PersonneInterface{
    private String nom;
    private String prenom;
    private int age;
    
    public Personne(String nom, String prenom, int age) throws RemoteException{
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }

    public void vieillir() throws RemoteException{
        
        age++;
    }

    public void afficherAge() throws RemoteException{
        System.out.println(prenom+" "+nom+" a "+age+ "ans");
    }
}

```

 - PersonneInterface.java

```java
import java.rmi.*;

interface PersonneInterface extends Remote{
    public void vieillir() throws RemoteException;
    public void afficherAge() throws RemoteException;
}

```

 - Dans le client lui passer un objet de Type : PersonneInterface

```java
PersonneInterface p=new Personne ("Lucky", "Luke", 30);
```

- Dans Traitement & son interface ( flemme de tout recopier
```java
public void vieillirPersonne(PersonneInterface p) throws RemoteException {
```


Qu'est ce qui est maintenant affiché par le client ?

```bash
Luke Lucky a 31ans
```
