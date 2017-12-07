import java.rmi.*;
import java.rmi.server.*;

class Traitements extends UnicastRemoteObject implements TraitementsInterface{

    public Traitements () throws RemoteException{
        super(); // constructeur de la classe mère
    }

    public void vieillirPersonne(Personne p) throws RemoteException {
        p.vieillir();
    }
}
