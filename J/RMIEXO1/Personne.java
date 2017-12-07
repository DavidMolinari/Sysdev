import java.io.*;

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
