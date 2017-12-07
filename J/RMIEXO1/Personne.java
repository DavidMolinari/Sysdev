import java.io.*;

class Personne implements Serializable{
    private String nom;
    private String prenom;
    private int age;
    
    public Personne(String nom, String prenom, int age){
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }

    public void vieillir(){
        age++;
    }

    public void afficherAge(){
        System.out.println(prenom+" "+nom+" a "+age+ "ans");
    }
}
