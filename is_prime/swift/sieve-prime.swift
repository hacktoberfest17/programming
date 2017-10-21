//Author: NerdOfCode
//Tested: Ubuntu 16.04

import Foundation
//For user input
print("Please enter a number: ")
//Get user input. Unwrap using !
var userinput: String = readLine()!
//Change userinput to a integer
var change = Int("\(userinput)")
var n: Int = change!
var guess = 1
while(true){
  //If n is disvisble by guess and is not equal to guess and is not 1
  if(n % guess == 0) && (n != guess) && (guess != 1){
    //Not prime numbers
    //Move on to the next lower number
    n=n-1
    guess=1
   //If n is equal to guess and n is not 1
  }else if(n == guess) && (n != 1){
    print("Prime: \(n)")
    //Move on to next lower number
    n=n-1
    //Reset guess
    guess=1
    //For some reason 2 never shows. Add it manually for now
  }else if(n == 2){
    print("Thats about it. Ooops, forgot 2")
    exit(0)
}else{
    //No matches, Add one to guess
    guess+=1
  }

}
