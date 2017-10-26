#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

const char * quiSuisJe=NULL;
int main(){
	pid_t pid ;
	quiSuisJe= "le père";
	pid=fork();	
	if (pid==0){
		quiSuisJe="le fils";
		printf("je suis %s\n", quiSuisJe);
	}
	else printf("je suis %s\n", quiSuisJe);
	return 0;
}