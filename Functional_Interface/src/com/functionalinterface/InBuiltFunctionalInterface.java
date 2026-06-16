package com.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InBuiltFunctionalInterface {
    public static void main(String[] args) {

        Consumer<Integer> calculateFactorial = (val) -> {
            int factorial = 1;
            for (int i = 1; i <= val; i++) {
                factorial *= i;
            }
            System.out.println("Factorial of " + val + " is " + factorial);

        };

        Predicate<Integer> isPrime = (val) -> {
            if(val <= 2) return false;
            for (int i = 2; i < Math.sqrt(val); i++) {
                if (val % i == 0) {
                    return false;
                }
            }
            return true;
        };

        BiFunction<Integer, Integer, Integer> findMax = (val1, val2) -> {
            if (val1 > val2) return val1;
            return val2;
        };

        calculateFactorial.accept(5);
        System.out.println(isPrime.test(16));
        System.out.println(findMax.apply(5, 10));

    }

}
