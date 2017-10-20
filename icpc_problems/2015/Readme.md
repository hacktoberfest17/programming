# ACM ICPC 2015 Problems and Solutions

## Problem A: Amalgamated Artichokes

Time Limit: 5 seconds

Fatima Cynara is an analyst at Amalgamated Artichokes (AA). As with any company, AA has had some very good times as well as some bad ones. Fatima does trending analysis of the stock prices for AA, and she wants to determine the largest decline in stock prices over various time spans. For example, if over a span of time the stock prices were 19, 12, 13, 11, 20 and 14, then the largest decline would be 8 between the first and fourth price. If the last price had been 10 instead of 14, then the largest decline would have been 10 between the last two prices.

Fatima has done some previous analyses and has found that the stock price over any period of time can be modelled reasonably accurately with the following equation:
##### price(k) = p · (sin(a · k + b) + cos(c · k + d) + 2)

where p, a, b, c and d are constants. Fatima would like you to write a program to determine the largest price decline over a given sequence of prices.You have to consider the prices only for integer values of k.

### Input

The input consists of a single line containing 6 integers p (1 ≤ p ≤ 1000), a, b, c, d (0 ≤ a, b, c, d ≤ 1000) and n (1 ≤ n ≤ 10^6). The first 5 integers are described above. The sequence of stock prices to consider is price(1), price(2), . . . , price(n).

### Output

Display the maximum decline in the stock prices. If there is no decline, display the number 0. Your output should have an absolute or relative error of at most 10^−6.


| Sample Input 1 | Sample Output 1|
| ------------- |:-------------:| 
| 42 1 23 4 8 10 | 104.855110477 | 

| Sample Input 2 | Sample Output 2|
| ------------- |:-------------:| 
| 100 7 615 998 801 3 | 0.00 |

| Sample Input 3 | Sample Output 3|
| ------------- |:-------------:| 
| 100 432 406 867 60 1000| 399.303813|
 

### Solution

Simple loop execution; Maintain maximum price encountered so far. 
