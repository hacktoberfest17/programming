public class Primes2{
public static void main(String[] cmdLn){
int n = Integer.parseInt(cmdLn[0]);
int x = 0;
for(int i = 2; i <= n; i++){
// count the proper divisors of i:
int pd = 0;
for(int k = 2; k < i; k++){
if (i % k == 0){
pd = pd + 1;
}
}
// i is a prime number if the number of proper divisors is 0!
if(pd == 0){
x = x + (i - i + 1);
}
}
System.out.println(x);
System.out.println(x/Math.log(x));
}
}
