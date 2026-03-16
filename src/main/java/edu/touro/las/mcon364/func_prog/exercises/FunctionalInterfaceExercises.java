package edu.touro.las.mcon364.func_prog.exercises;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Functional Interface Practice
 *
 * In this assignment you will:
 *  - Create and return different functional interfaces
 *  - Apply them
 *  - Practice chaining where appropriate
 *
 * IMPORTANT:
 *  - Use lambdas
 *  - Do NOT use anonymous classes
 */
public class FunctionalInterfaceExercises {

    // =========================================================
    // PART 1 — SUPPLIERS
    // =========================================================

    /**
     * 1) Create a Supplier that returns the current year.
     *
     * Hint:
     * You can get the current date using:
     *     LocalDate.now()
     *
     * Then extract the year using:
     *     getYear()
     *
     * Example (not the solution):
     *
     */
    public static Supplier<Integer> currentYearSupplier() {
        Supplier<Integer> currentYearSupplier = () ->  LocalDate.now().getYear();
        return currentYearSupplier;
    }

    /**
     * 2) Create a Supplier that generates a random number
     * between 1 and 100.
     */
    public static Supplier<Integer> randomScoreSupplier() {
        return () -> ThreadLocalRandom.current().nextInt(1, 100);

    }

    // =========================================================
    // PART 2 — PREDICATES
    // =========================================================

    /**
     * 3) Create a Predicate that checks whether
     * a string is all uppercase.
     */
    public static Predicate<String> isAllUpperCase() {
        return s -> s != null && s.equals(s.toUpperCase());

    }

    /**
     * 4) Create a Predicate that checks whether
     * a number is positive AND divisible by 5.
     *
     * Hint: consider chaining.
     */
    public static Predicate<Integer> positiveAndDivisibleByFive() {
        Predicate<Integer> DivisibleByFive = x -> x % 5 == 0;
        Predicate<Integer> positive = x -> x > 0;
        return   DivisibleByFive.and(positive);
    }

    // =========================================================
    // PART 3 — FUNCTIONS
    // =========================================================

    /**
     * 5) Create a Function that converts
     * a temperature in Celsius to Fahrenheit.
     *
     * Formula: F = C * 9/5 + 32
     */
    public static Function<Double, Double> celsiusToFahrenheit() {
      return C -> C * 9/5 + 32;
    }

    /**
     * 6) Create a Function that takes a String
     * and returns the number of vowels in it.
     *
     * Bonus: Make it case-insensitive.
     */
    public static Function<String, Integer> countVowels() {


        Function<String, Integer> l = s -> {
            int counter = 0;
            for (int i = 0; i < s.length(); i++) {
                char curr = s.toLowerCase().charAt(i);
                if (curr == 'a' || curr == 'e' || curr == 'i'
                        || curr == 'o' || curr == 'u'){
                    counter++;
            }}
            return counter;
        };

            return l;

    }


    // =========================================================
    // PART 4 — CONSUMERS
    // =========================================================

    /**
     * 7) Create a Consumer that prints a value
     * surrounded by "***"
     *
     * Example output:
     * *** Hello ***
     */
    public static Consumer<String> starPrinter() {
        // TODO
        Consumer<String> printer = p -> System.out.println("*** " + p + " ***");
        printer.accept("Hello");
        return printer;
    }

    /**
     * 8) Create a Consumer that prints the square
     * of an integer.
     */
    public static Consumer<Integer> printSquare() {
     Consumer<Integer> printer = i -> System.out.println(i*i);
        printer.accept(6);
        return printer;
    }

    // =========================================================
    // PART 5 — APPLYING FUNCTIONAL INTERFACES
    // =========================================================

    /**
     * 9) Apply:
     *  - A Predicate
     *  - A Function
     *  - A Consumer
     *
     * Process the list as follows:
     *  - Keep only strings longer than 3 characters
     *  - Convert them to lowercase
     *  - Print them
     */
    public static void processStrings(List<String> values) {
        Predicate<String> longerThan3 = s -> s.length() > 3;
        Function<String, String> lower = String::toLowerCase;
        Consumer<String> print = System.out::println;

        for (String value : values) {

            if (longerThan3.test(value)) {
                String result = lower.apply(value);
                print.accept(result);
            }
        }
    }

    /**
     * 10) Apply:
     *  - A Supplier
     *  - A Predicate
     *  - A Consumer
     *
     * Generate 5 random scores.
     * Print only those above 70.
     */
    public static void generateAndFilterScores() {
        Supplier<Integer> diceRoll = () -> ThreadLocalRandom.current().nextInt(1, 101);
      Predicate<Integer> isAbove = s -> s > 70 && s <= 100 ;
      Consumer<String> printer = System.out::println;

      for(int i=0; i<5; i++){
          int result= diceRoll.get();
         if(isAbove.test(result)){
          printer.accept(String.valueOf(result));
      }
    }}
}
