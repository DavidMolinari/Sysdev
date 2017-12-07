#include <rpc/rpc.h>
#include <stdio.h>
#include <stdlib>
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

/* Fonction d'/de … */
bool_t encoding_operands(XDR *x, struct operands *ops){
    if(ops != NULL){
        xdr_int(x, ops->op1);
        xdr_int(x, ops->op2);
    } else return FALSE;
}

/* Fonction appelable à distance qui calcule la somme de 2 entiers */
int *add (struct operands *ops){
    return (int)ops->op1 + (int)ops->op2;
}

main(int argc, char *argv[]){

   pmap_unset(ARITHM_PROG_NUM, ARITHM_VERS_NUM);

    /* Enregistrement de la fonction auprès du portmap */
    ….....

    if (r==-1){
        perror("Registering service\n");
        exit(1);
    }
    svc_run();
    exit(0);
}
