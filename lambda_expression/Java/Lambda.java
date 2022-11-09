
/*
 * Use java8's Lambda to implement number check, provide more clean code
 * 
 * Method: Check number is Odd or Even / is Prime / is Palindrome
 * 
 * For example: Lambda lambda = Lambda();
 *              PerformOperation p = lambda.isOdd();
 *              Boolean ret = po.checker(p, 5); // will return true
 * */


import java.io.*;
import java.util.*;
interface PerformOperation {
	boolean check(int num);
}

public class Lambda {
	public  boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}
	
	public PerformOperation isOdd() {
		return (int num) -> {
			if(num % 2 == 0) {
				return false;
			}
			else {
				return true;
			}
			
		};
	}
	
	public PerformOperation isPrime() {
		return (int num) -> {
			if(num <= 1) {
				return false;
			}
			
			for(int i=2; i <= Math.sqrt(num); i++) {
				if(num % i == 0) {
					return false;
				}
			}
			
			return true;
			
		};
	}
	
	public PerformOperation isPalindrome() {
		return (int num) -> {
			String toStr = String.valueOf(num);
			return toStr.equals(new StringBuffer().append(toStr).reverse().toString());
		};
	}
	
	public enum Operation {
	    CHECK_ODD_OR_EVEN(1), CEHCK_PRIME(2), CHECK_PALINDROME(3);
	    private final int value;

	    private Operation(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	}
}


