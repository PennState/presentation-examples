package edu.psu.presenations.utilities;

import java.util.OptionalLong;
import java.util.stream.LongStream;

public class PrimeUtilities {

  private PrimeUtilities() {
  }

  public static LongStream factorStream(long number) {
    return LongStream.rangeClosed(2, (long) Math.sqrt(number))
        .filter(f -> number % f == 0)
        .flatMap(f -> LongStream.of(f, number / f))
        .sorted();
  }

  public static boolean isPrime(long number) {
    return !factorStream(number)
        .findFirst()
        .isPresent();
  }

  public static LongStream primeFactorStream(long number) {
    return factorStream(number)
        .flatMap(f -> isPrime(f) ? LongStream.of(f) : primeFactorStream(f))
        .distinct();
  }

  public static OptionalLong smallestPrimeFactor(long number) {
    return primeFactorStream(number)
        .sorted()
        .findFirst();
  }

  public static void main(String[] args) {
    System.out.println("1234 is prime: " + isPrime(1234L));
    System.out.println("1237 is prime: " + isPrime(1237L));
    System.out.println("125 is prime: " + isPrime(125L));
    System.out.println("125 is prime: " + isPrime(360L));

    System.out.println("Factors of 1234 are: " + LongStreamUtilities.toString(factorStream(1234L)));
    System.out.println("Factors of 125 are: " + LongStreamUtilities.toString(factorStream(125L)));
    System.out.println("Factors of 360 are: " + LongStreamUtilities.toString(factorStream(360L)));

    System.out.println("Prime factors of 1234 are: " + LongStreamUtilities.toString(primeFactorStream(1234L)));
    System.out.println("Prime factors of 125 are: " + LongStreamUtilities.toString(primeFactorStream(125L)));
    System.out.println("Prime factors of 360 are: " + LongStreamUtilities.toString(primeFactorStream(360L)));

    System.out.println("Smallest prime factor of 1234 is: " + smallestPrimeFactor(1234L));
    System.out.println("Smallest prime factor of 1237 is: " + smallestPrimeFactor(1237L));
    System.out.println("Smallest prime factor of 125 is: " + smallestPrimeFactor(125L));
    System.out.println("Smallest prime factor of 360 is: " + smallestPrimeFactor(360L));
  }

}
