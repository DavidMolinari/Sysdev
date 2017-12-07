import java.rmi.*;

interface PersonneInterface extends Remote{
    public void vieillir() throws RemoteException;
    public void afficherAge() throws RemoteException;
}
