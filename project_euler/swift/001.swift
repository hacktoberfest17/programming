/*
 * Project Euler 001 : Swift
 * http://projecteuler.net/problem=001
 *
 * Author: Matt McAlister (@matmcal)
 *
 * Task:
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
 */


var count = 0;
var sum = 0;
while(count < 1000){
    if(count % 3 == 0 || count % 5 == 0){
        sum = sum + count;
    }
    count = count + 1;
}

print(sum);
