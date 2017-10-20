#include<iostream>
#include<conio.h>
using namespace std;

/*
****TOWER OF HANOI****
Problem Background : https://en.wikipedia.org/wiki/Tower_of_Hanoi

----Legends---
n->number of disks
S->source pole
T->Temperory Pole
D->Destination Pole

----How it Works----
So if i want to move, say, 5 disks, i will break it down like this:-
If I knew a way how to move 'n-1' (here 5-1 = 4) to temperory pole I can easily move the
fifth disk to the destination pole and then move my 4 poles from temp pole
to the dest pole as well. Pretty easy, huh?
But the catch is that, I don't know how to move 4 poles at a time. 
Wait! What if knew how to move 3 disks at a time?
I wish i could!
I don't know it either.
So going on likewise I reach my base case with 1 disk scenario.
Hey I should be able to do atleast this.There should not be any problem, I guess.
True.
I can pretty easily write some printing statement if n is 1, like 
"Hey, move the disk from 'Source' to 'Destination'. Just move it".
So this is my BASE CASE. That is when, n==1.

So let me summarize the points:-
0.We have n disks in S
1.We move n-1 disks from S to T
2.We move the 1 remanining disk in S to D
3.We move the n-1 disks from T to D
Tada!

*/

int count;

// function declaration
int towerOfHanoi(int n,char S,char T,char D);

int main() {
  int n;
  cout<<"enter number: ";
  cin>>n;
  towerOfHanoi(n,'S','T','D');
  cout<<"Number of steps: "<<count;
  getch();
}

// function definition
int towerOfHanoi(int n,char S,char T, char D) {
  if(n==1){
    cout<<S<<" to "<<D<<endl;
    count++;
  }
  else{
    towerOfHanoi(n-1,S,D,T);
    towerOfHanoi(1,S,T,D);
    towerOfHanoi(n-1,T,S,D);
  }	
}


	
