#include<stdio.h>
#include<unistd.h>

int main(){
    int pid;
    /*
      getpid() returns the process ID of the process which calls it.
    */
    pid = getpid();
    printf("My process ID is %d\n", pid);

    // Check your 'top' and see if the process id is matching.
    //After the sleep ends, the program will exit and will be removed from top
    sleep(30);
    
    return 0;
}
