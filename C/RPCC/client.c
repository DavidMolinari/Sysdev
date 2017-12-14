#include <rpc/rpc.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <string.h>
#include <strings.h>

#define ARITHM_PROG_NUM ((u_long)0x33333333)
#define ARITHM_VERS_NUM ((u_long)1)
#define ADD_FCT_NUM ((u_long)1)

/* Deux entiers pour le calcul */
struct operands{
    int op1;
    int op2;
};

/* Fonction d'/de… */
bool_t encoding_operands(XDR *x, struct operands *ops){
    /* Même chose que pour serveur.c */     
    if(ops != NULL){
        xdr_int(x, &(ops->op1));
        xdr_int(x, &(ops->op2));
    } else return -1;
}

/* Fonction principale. argv[1] : hôte distant. argv[2] : première opérande. argv[3] : deuxième opérande. */

main(int argc, char *argv[]){



    if (argc<4){
        fprintf(stderr, "missing parameters\n")
        exit(1)
    }

    char *host=argv[1];

    /* Récupération des deux entiers */


    ops->op1 = argv[3];
    ops->op2 = argv[4];

   /* Entier qui contiendra leur somme*/
    int result;

    /* Appel de la fonction distante */

    int sockLoc = socket(AF_INET, SOCK_STREAM, 0);
    CLIENT *clnt;
    clnt = CLIENT *clnttcp_create(host,ARITHM_PROG_NUM,ARITHM_VERS_NUM,sockLoc,500,500);



    struct operands ops;
    


    int r = clnt_call(clnt,ARITHM_PROG_NUM,encoding_operands, argv, result, char *out, 500);

    if (r==-1){
        perror("Registering service\n");
        exit(1);
    }

    printf("La somme de %d et %d est : %d\n", ops.op1, ops.op2, result);
    exit(0);

}
