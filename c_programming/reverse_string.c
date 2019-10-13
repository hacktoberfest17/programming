#include<stdio.h>

void main(){
  char str[20];
  int i;
  
  //Input String
  printf("\n Enter the String : ");
  scanf("%[^\n]",str);
  
  //Loop to count the number of characters in the String (This can alse be done with Library functions)
  while(str[i]!='\0')
    i++;
  
  //Printing Reverse of the given String
  printf("\n REVERSE : ");
  while(i!=-1){
    printf("%c",str[i]);
    i--;
  }
  printf("\n\n");
 }
