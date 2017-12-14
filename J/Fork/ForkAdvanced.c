#include <stdio.h>
#include <unistd.h>
#include <signal.h>

int main()
{    
    pid_t pid = fork();
    if (pid == 0){
        for (int i = 0; i <= 100; ++i) {
            if(i%2==1) {
                printf("ENFANT: nb=%d\n", i);
                kill(getppid(), SIGUSR1);
                pause();

        }
    }
    } else if (pid > 0) {
        for (int j = 0; j <= 100; ++j){
            if(j%2==0) 
            {
                printf("PARENT: nb=%d\n", j);

                pause();
                kill(pid, SIGUSR2);   

                }
        }   
    }
    return 0;
}

