#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>

#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <netdb.h>


int main(int argc, char *argv[]){ 

    /* 1. Récupération des paramètres d'entrée */

        short portLoc = (short) atoi(argv[1]) ;		/* numéro de port local */
        char *nomServ;
        nomServ = argv[2];		/* Pointeur sur le nom du serveur */
        short portServ  = (short) atoi(argv[3]) ;		/* numéro de port serveur */
        char *msgEnvoi;
        msgEnvoi = argv[4] ; 		/* Pointeur sur le message à envoyer */
        int  tailleMsgEnvoi= atoi(argv[5]) ;		/* taille du message */
	
        /* 2. Déclaration des variables permettant la communication sur le réseau */

        int sockLoc;	// descripteur de la socket locale (cliente)
        struct hostent* infosServ;   	/* Informations du serveur */
        struct sockaddr_in infosAddrLoc;  	/* Informations d'adressage de la socket locale */
        struct sockaddr_in infosAddrServ;    	/* Informations d'adressage de la socket serveur */
        int tailleInfosAddrLoc, tailleInfosAddrServ ;	/* taille des informations d'adressage de la socket locale */

        char msgRecu [1000] ;	 /* Buffer qui contiendra la réponse du serveur */

        /* 3. Création de la socket en mode connecté, si création réussie retourne son descripteur dans sockLoc, sinon on    
        quitte le programme */
        int sock = socket(AF_INET, SOCK_STREAM, 0);

        // if(sock == INVALID_SOCKET){
        if(sock == -1){
            perror("Socket()");
            exit(errno);
        } else {
            // COMMENT ON FAIT ? //TODO
            sockLoc = sock;
            printf("Socket = %d\n", sock);
            printf("%d\n", sockLoc);
        }

        int errno;

        printf("SIZEOF(INFOADDRLOC) : %d\n",sizeof(infosAddrLoc) );
        printf("INFOADDRLOC.sin_port : %d\n",infosAddrLoc.sin_port);
        printf("INFOADDRLOC.sin_addr : %d\n",infosAddrLoc.sin_addr.s_addr);


        if(bind(sock, (struct sockaddr *) &infosAddrLoc, sizeof(infosAddrLoc) == -1)){
            printf("BIND RETURN -1\n");
            printf("MESSAGE : %s\n",strerror(errno));

        }else printf("TUTTI VA BENE\n");
        // ….....
        // ….....
        // ….....

        /* 4. Mise à jour des informations d'adressage locales */

        /* 4.1. Mise à jour du domaine de la socket locale */
        // ….....

        /* 4.2. Mise à jour du numéro de port local après avoir fait la conversion en format réseau */
        // ….....

        infosAddrLoc.sin_addr.s_addr = htonl(INADDR_ANY);  /* 4.3. Que fait-on ici  ? */  
        /* …..... */

        /* 4.4. Mise à jour de tailleInfosAddrLoc */
        // tailleInfosAddrLoc = sizeof(infosAddrLoc);

        /* 5. Attachement de la socket locale, si erreur on quitte le programme */ 
        // ….....
        // ….....
        // ….....

        /* 6. Récupère les informations du serveur à partir de son nom */
        // infosServ = gethostbyname(nomServ);           

        /* 7. Mise à jour des informations d'adressage du serveur */

        // infosAddrServ.sin_family = infosServ->h_addrtype;	/* Mise à jour du domaine de la socket serveur */
        // infosAddrServ.sin_port = htons(portServ);            /* Mise à jour du numéro de port serveur */
        // memcpy(&infosAddrServ.sin_addr, infosServ->h_addr, infosServ->h_length);	/*Mise à jour de l'adresse IP du serveur*/
  
        // printf("Adresse du serveur: %s \n", inet_ntoa(infosAddrServ.sin_addr));
  
        // tailleInfosAddrServ = sizeof(infosAddrServ);	/* Mise à jour de tailleInfosAddrServ */
  
        /* 8. Connexion au serveur, si problème de connexion on quitte le programme */
        // ….....
        // ….....
        // ….....

        /* 9. Envoi d'un message au serveur */
        // ….....

        /* 10. Récupère la réponse du serveur et l'affiche */
        // ….....
        // ….....

        /* 11. Fermeture de la socket */
        close(sockLoc) ;
}

