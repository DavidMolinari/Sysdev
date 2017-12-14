#include <stdio.h>
#include <unistd.h>

int main()
{    
    pid_t pid = fork();
    wait(0);
    if (pid == 0) for (int i = 0; i <= 50; ++i) printf("ENFANT: nb=%d\n", i);
    else if (pid > 0) for (int j = 51; j <= 100; ++j) printf("PARENT: nb=%d\n", j);
    return 0;
}

