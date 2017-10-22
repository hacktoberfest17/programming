#include<stdio.h>
#include<unistd.h>

int main(){
    int pid;
    int var;

    // Assign some random value to 'var'
    var = 53;

    pid = fork();

    if(pid == 0){
	printf("Child ID\t%d\n", getpid());

	// Change variable value
	var = -100;
    }
    else{
	printf("Parent ID\t%d\n", getpid());

	// Change variable value
	var = 100;
    }

    printf("var = %d\t'var' address = %p\tprocessID = %d\n", var, &var, getpid());
    return 0;
}
