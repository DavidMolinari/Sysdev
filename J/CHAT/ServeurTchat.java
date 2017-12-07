import java.rmi.*;
import java.rmi.server.*;
import java.net.*;
import java.util.*;

public class ServeurTchat extends UnicastRemoteObject implements ServeurTchatInterface{

    // Vector<ClientChat> clients=new Vector<ClientChat>();
    Vector<ClientTchatInterface> clients = new Vector<ClientTchatInterface>();

    public ServeurTchat () throws RemoteException {
        super();
    }

     /* en-tête de la méthode enregistrementClient(...) */
    public void enregistrementClient(ClientTchatInterface client) throws RemoteException{
        clients.add(client);
    }
    
     /* en-tête de la méthode desenregistrementClient(...) */
     public void desenregistrementClient(ClientTchatInterface client) throws RemoteException{
        for (int i=0; i<clients.size(); i++)
            if (client.equals((ClientTchatInterface)(clients.get(i))))
                clients.removeElementAt(i);
    }

    /* retourne le nombre de clients en cours */
    public int nbClientsEnCours() throws RemoteException {
        return clients.size();
    }

    /* En-tête de la méthode transfertMessage(...) */
    public void transfertMessage(String msg) throws RemoteException{
        for (int i=0; i<clients.size(); i++){
            ClientTchatInterface client= (ClientTchatInterface)(clients.get(i));
            client.recuperationNouveauMessage(msg);
        }
    }

    public void afficheMessage(String msg) throws RemoteException{
        System.out.println(msg);
        for (int i=0; i<clients.size(); i++){
                ClientTchatInterface client= (ClientTchatInterface)(clients.get(i));
                client.recuperationNouveauMessage(msg);
            }

    }



    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            String url="rmi://"+InetAddress.getLocalHost().getHostAddress()+"/tchat";
            ServeurTchat srv = new ServeurTchat();
            /* On enregistre dans la rmiregistry un objet de la classe courante */ 
            Naming.rebind(url, srv);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
