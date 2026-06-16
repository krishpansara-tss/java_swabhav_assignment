package com.functionalinterface;

public class Main {
    public static void main(String[] args) {

        FactorialInterface calculateFactorial = (int val) -> {
            int factorial = 1;

            for(int i = 1; i <= val; i++){
                factorial *= i;
            }

            System.out.println("Factorial Of " + val + " is " + factorial);
        };

        SumOfNumbers calculateSum = (int... val) -> {
            int sum = 0;

            for(int i : val){
                sum += i;
            }

            System.out.println("Sum of given val  is :  " + sum);
        };

        MaxElement findMax = (int val1, int val2) -> {
            if(val1 > val2){

                System.out.println("Max is :  " + val1);
            }else{
                System.out.println("Max is :  " + val2);
            }
        };

        PrimeNumber isPrime = (int val) -> {

            for(int i = 2; i <= Math.sqrt(val); i++ ){
                if (val % i == 0) {

                    return false;
                }
            }

            return true;
        };


        findMax.findMax(5, 10);
        calculateSum.calculateSum(5 ,10, 15);
        System.out.println(isPrime.checkPrime(5));
        calculateFactorial.calculateFactorial(5);
    }
}
