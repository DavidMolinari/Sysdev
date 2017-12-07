import java.rmi.*;

public class PetitClient{ 
    public static void main(String args[]){
        try {

            if (args.length<1){
                System.out.println("Nom d'hôte SVP");
                return;
            }
            String nom_hote=args[0];

            Personne p=new Personne ("Lucky", "Luke", 30);

            TraitementsInterface traitementsInterface =(TraitementsInterface)Naming.lookup("rmi://"+nom_hote+":1099/traitements"); 
            traitementsInterface.vieillirPersonne(p);

            p.afficherAge();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
