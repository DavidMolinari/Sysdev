import java.rmi.*;

interface ClientTchatInterface extends Remote{
    public void recuperationNouveauMessage(String msg) throws RemoteException;

}
