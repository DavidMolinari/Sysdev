#include <stdio.h>
#include <unistd.h>

int main()
{    
    pid_t pid = fork();
 
    for (int i = 0; i <= 100; ++i) {
            if (pid == 0){
                if(i%2==0) 
                printf("ENFANT: nb=%d\n", i);
        }
            else if(pid > 1){
                if(i%2==0) 
                    printf("PAPA: nb=%d\n", i);            
            }
    
    }
    return 0;
}

