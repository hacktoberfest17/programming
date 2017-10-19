#include<stdio.h>
#include<unistd.h>
int main(){
    int pid;

    // The child wasn't created yet. So only the parent will print this line
    printf("This is before fork\t%d\n", getpid());
    pid = fork();

    // Both child and parent run from this point after the fork.

    printf("This will be printed twice\t%d\n", getpid());

    if(pid == 0){
	printf("Only child will print this\t%d\n", getpid());
    }
    else{
	printf("Only parent will print this\t%d\n", getpid());
    }

    printf("Both will execute this\t%d\n", getpid());

    return 0;
}
