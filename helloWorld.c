#include<stdio.h>
#include<stdlib.h>

int main( int argc, char * argv[] ){

 int i; 

 if( argc == 1 ){
  printf("Error...needs a cmd arg\n");
  exit(1);
 }

 char hi[] = "Hello World";

 char * s = argv[1]; 
 int a = atoi(s); 
 
 for( i = 1; i <= a; i++ ){
  printf("%s",hi);
  printf("...#%d\n",i);
 }
 exit(0);
}
