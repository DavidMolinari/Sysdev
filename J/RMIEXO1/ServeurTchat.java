import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.util.*;

public class ServeurTchat extends UnicastRemoteObject implements ServeurTchatInterface{

    Vector clients=new Vector();

    public ServeurTchat () throws RemoteException {
        super();
    }

     /* en-tête de la méthode enregistrementClient(...) */
    ….....
        clients.add(client);
    }

     /* en-tête de la méthode desenregistrementClient(...) */
    ….....
        for (int i=0; i<clients.size(); i++)
            if (client.equals((ClientTchatInterface)(clients.get(i))))
                clients.removeElementAt(i);
    }

    public int nbClientsEnCours() throws RemoteException {
        return clients.size();
    }

    /* En-tête de la méthode transfertMessage(...) */
    ….....
        for (int i=0; i<clients.size(); i++){
            ClientTchatInterface client= (ClientTchatInterface)(clients.get(i));
            client.recuperationNouveauMessage(msg);
        }
    }

    public static void main(String[] args) {
        try {

            java.rmi.registry.LocateRegistry.createRegistry(1099);

            String url="rmi://"+InetAddress.getLocalHost().getHostAddress()+"/tchat";

            /* On enregistre dans la rmiregistry un objet de la classe courante */ 
            ….....

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
