package com.kabricks;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //create scan object
        Scanner scan = new Scanner(System.in);

        //obtain number of values to be entered, or could use List or ArrayList
        //for added complexity.
        System.out.println("How many values do you want to test?");
        int num_values = scan.nextInt();

        //initialize array with values
        int[] values = new int[num_values];

        //get all values into the array based on expected numbers
        for (int count = 0; count < num_values; count++){
            if(0 == count){
                System.out.println("Input first number...");
                values[count] = scan.nextInt();
            } else {
                System.out.println("Input next number...");
                values[count] = scan.nextInt();
            }
        }

        //create main class object and pass along the good news
        Main main = new Main();

        main.oddEven(values);
        main.anyMultiples(values);
        main.jupiterAscending(values);
        main.allMathAllFun(values);
        main.pessimistsAndOptimistsAndIntertwines(values);
    }

    //print all odd or even numbers
    private void oddEven(int[] values){
        System.out.println("--------");
        for (int a : values) {
            if(0 == a%2){
                //is even
                System.out.println(a + " is an even number");
            } else {
                //is odd
                System.out.println(a + " is an odd number");
            }
        }
    }

    //print all in ascending order, bad movie by the way? ;)
    private void jupiterAscending(int[] values){
        System.out.println("--------");
        System.out.println("In ascending order");
        Arrays.sort(values);
        for (int a : values){
            System.out.println(a);
        }
    }

    //print any multiples if they exist
    private void anyMultiples(int[] values){
        System.out.println("--------");
        for(int a : values){
            for(int b : values){
                if(0 == a % b){
                    //is a multiple
                    System.out.println(a + " is a multiple of " + b);
                } else {
                    System.out.println(a + " is not a multiple of " + b);
                }
            }
        }
    }

    //lots of math functions here
    private void allMathAllFun(int[] values){
        System.out.println("--------");
        int sum = 0;
        int product = 0;
        int average;
        for(int a : values){
            sum += a;
            product *= a;
        }

        average = sum / 2;

        System.out.println("Sum is " + sum);
        System.out.println("Product is " + product);
        System.out.println("Average is " + average);
    }

    //print all positives, negatives and the plain boring number. 0
    private void pessimistsAndOptimistsAndIntertwines(int[] values){
        System.out.println("--------");
        for(int a : values){
            if(a < 0){
                //is negative
                System.out.println(a + " is negative");
            } else if(a > 0) {
                //is positive
                System.out.println(a + " is positive");
            } else {
                //is 0
                System.out.println(a + " is zero");
            }
        }
    }
}
