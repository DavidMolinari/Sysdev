import java.net.*;
import java.io.*;
import java.util.*;

public class SocketConnecteeCliente {

        // static String adresseIPServeur="localhost";
        static String adresseIPServeurDylan="u1-110-2";  // BIGHOST
        static int numeroPortServeur=1234;

        public static void main(String[] args) {
                        Socket socketCliente = new Socket();
                try {
                        /* Connexion à la socket serveur */
                        System.out.println(args);
                        socketCliente.connect(new InetSocketAddress(adresseIPServeurDylan, numeroPortServeur));
                        System.out.println(socketCliente);
                        while(true){
                                Scanner keyboard = new Scanner(System.in);
                                System.out.print ("Votre message (finir par -1) : ");
                                String message=keyboard.nextLine();

                                BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); 
                                PrintStream out = new PrintStream(socketCliente.getOutputStream()); 
                
                                out.println(message); 

                                if (message.contains("-1")) {

                                        socketCliente.close(); 
                                        break;
                                }

                                System.out.println("Votre message en majuscule : "+ in.readLine()); 

                        }
                        socketCliente.close();

                } 
                catch (Exception e) {
                        System.out.println(socketCliente);
                        e.printStackTrace();
                }
        }
}
