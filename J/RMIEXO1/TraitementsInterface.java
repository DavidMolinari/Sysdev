import java.rmi.*;

interface TraitementsInterface extends Remote{
    public void vieillirPersonne(Personne p) throws RemoteException;
}
