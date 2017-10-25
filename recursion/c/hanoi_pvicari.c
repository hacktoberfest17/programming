/* Hanoi Tower */
/* Author: pvicari */
/* Language: C */
/* Category: Recursion */
/* Description: Solve Tower of Hanoi problem */


#include <stdio.h>
#include <stdlib.h>

void Move_Disk(int A, int B);
void Hanoi(int N, int P1, int P2, int P3);

//A -> Source Tower
//B -> Target Tower
void Move_Disk(int A, int B){
 static int mov = 1;
 printf("\n  ( %3d move  )  %d ----> %d", mov++, A, B);
}

//N -> Number of disks
//P* -> Towers
void Hanoi(int N, int P1, int P2, int P3){
  if ( N > 0 )
     {
      Hanoi(N-1,P1,P3,P2);
      Move_Disk(P1,P2);
      Hanoi(N-1,P3,P2,P1);
     }
}// Hanoi

int main(void) {
 printf("\n\n\n");
 Hanoi(5,1,3,2);
 printf("\n\n\n");
 
 system("Pause");
 return(0);
}


