#include<stdio.h>
#include<unistd.h>

int main(){
    int pid;

    /*
      Return value of fork() is stored in pid. When fork creates B as a copy of A, the value of the variable pid is set to zero in B. whereas its value is equal to (process ID of B) in process A. These processes now run seperately with differnt process IDs.
    */
    pid = fork();

    if(pid == 0){
	// pid is ZERO for the child process.
	printf("\n\tI'm the child\nMy ID is %d and pid = %d\n\n", getpid(), pid);
	return 0;
    }
    else{
	// pid is non-ZERO for the parent.
	printf("\n\tI'm the parent\nMy ID is %d and pid = %d\n", getpid(), pid);
	printf("Note that the value in my variable 'pid' is same as the process ID of my child\n\n");
	return 0;
    }
}
