#include<stdio.h> //printf
#include<string.h> //memset
#include<stdlib.h> //for exit(0);
#include<sys/socket.h>
#include<errno.h> //For errno - the error number
#include<netdb.h> //hostent
#include<arpa/inet.h>

struct in_addr{
	unsigned long;
}
struct hostent{
	char *h_name;
	char **h_aliases;
	int h_addrtype;
	int h_length;
	char **h_addr_list;
}
struct hostent* getHostByName(const char *name);
char * inet_ntoa(struct in_addr in);

void main(){
}


//TODO