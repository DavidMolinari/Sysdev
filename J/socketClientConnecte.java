import java.net.*;
import java.io.*;
import java.util.*;

public class SocketConnecteeCliente {

        static String adresseIPServeur="localhost";
        static int numeroPortServeur=1234;

        public static void main(String[] args) {
                try {
                        Socket socketCliente = new Socket();
                        /* Connexion à la socket serveur */
                        socketCliente.connect(new InetSocketAddress(adresseIPServeur, numeroPortServeur));
                        while(true){
                                Scanner keyboard = new Scanner(System.in);
                                System.out.print ("Votre message (finir par -1) : ");
                                String message=keyboard.nextLine();

                                BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream())); 
                                PrintStream out = new PrintStream(socketCliente.getOutputStream()); 

                                out.println(message); 

                                if (message.equals("-1")) 
                                        break;

                                System.out.println("Votre message en majuscule : "+ in.readLine()); 

                        }
                        socketCliente.close();

                } 
                catch (Exception e) {
                        e.printStackTrace();
                }
        }
}
