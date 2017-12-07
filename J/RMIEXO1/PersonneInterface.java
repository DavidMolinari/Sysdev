import java.rmi.*;

interface PersonneInterface extends Remote{
    public void viellir() throws RemoteException;
    public void afficherAge() throws RemoteException;
}
