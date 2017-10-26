#include<stdio.h>
#include<signal.h>
#include<unistd.h>

void sig_handler(int signo)
{
  if (signo == SIGINT)
    printf("> SIGINT reçu ! ! ! CTRL+C \n");
}
int main(void)
{
  if (signal(SIGINT, sig_handler) == SIG_ERR)
  printf("\n SIGINT ERREUR \n");
  while(1) 
    sleep(1);
  return 0;
}