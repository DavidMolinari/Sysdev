import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;

public class PetitServeur {
    public static void main(String[] args){
        try {

            LocateRegistry.createRegistry(1099);

            Traitements traitements= new Traitements();
            String url="rmi://"+InetAddress.getLocalHost().getHostAddress()+"/traitements";

            Naming.rebind(url, traitements);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
