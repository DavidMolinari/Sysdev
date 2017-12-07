import java.rmi.*;

interface ServeurTchatInterface extends Remote{
    /* A compléter */
    public void enregistrementClient(ClientTchatInterface client) throws RemoteException;
    public void desenregistrementClient(ClientTchatInterface client) throws RemoteException;
    public int nbClientsEnCours() throws RemoteException;
    public void transfertMessage(String msg) throws RemoteException;
    public void afficheMessage(String msg) throws RemoteException;

}
