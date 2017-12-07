import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ClientTchat extends UnicastRemoteObject implements ClientTchatInterface  {

    public ClientTchat()throws RemoteException{
        super();
    }

    /* Méthode recuperationNouveauMessage(...)  qui affiche un message reçu depuis le serveur */
    public void recuperationNouveauMessage(String msg){
        System.out.println("Le message est : " + msg);
        // LOL EZ
    }

    public static void main(String args[]){
        try {

            if (args.length<2){
                System.out.println("Nom d'hôte puis pseudo en ligne de commande SVP");
                return;
            }
            String nom_hote=args[0];
            String pseudo=args[1];

            ServeurTchatInterface serveurTchatInterface = (ServeurTchatInterface)Naming.lookup("rmi://"+nom_hote+":1099/tchat"); 

            /* Création d'un objet de la classe courante et enregistrement de celui-ci auprès du serveur */  
            ClientTchatInterface client = new ClientTchat(); //  NO 
            serveurTchatInterface.enregistrementClient(client);
            //TODO

            System.out.println ("Discussion (-1 pour la quitter) : ");
            while(true){
                Scanner keyboard = new Scanner(System.in);
                String s=keyboard.nextLine();
                if(s.equals("-1")){
                    /* Désenregistrement de l'objet courant auprès du serveur */
                    //TODO
                    System.exit(0);
                }

                /* Envoi d'un message au serveur */
                //TODO
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
