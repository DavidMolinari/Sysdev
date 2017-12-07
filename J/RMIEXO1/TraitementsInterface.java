import java.rmi.*;

interface TraitementsInterface extends Remote{
    public void vieillirPersonne(PersonneInterface p) throws RemoteException;
}
