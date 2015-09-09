package edu.psu.presenations.sequences;

import java.util.stream.LongStream;

import edu.psu.presenations.utilities.LongStreamUtilities;

/**
 * Produces a LongStream containing a "hailstorm sequence" for a given input.
 * This sequence is most commonly associated with the Collatz Conjecture which
 * states that this sequence will always converge if started with any Natural
 * number. This LongStream is therefore assumed to be finite.
 * 
 * https://en.wikipedia.org/wiki/Collatz_conjecture
 * 
 * @author Steve Moyer &lt;smoyer@psu.edu&gt;
 */
public class HailStorm {

  static final String EXCEPTION_NATURAL_NUMBER_REQUIRED = "The hailstorm series is only valid for Natural Numbers.";

  // Hide the default constructor
  private HailStorm() {
  }

  // Generates the next number in a Collatz series
  static long next(long number) {
    return number % 2 == 0 ? number / 2L : number * 3L + 1L;
  }

  static LongStream recurse(long n, LongStream a) {
    LongStream na = LongStream.concat(a, LongStream.of(n));
    if (n > 1) {
      na = recurse(next(n), na);
    }
    return na;
  }

  /**
   * Produces a hailstorm sequence for the provided long
   * 
   * @param n
   * @return
   */
  public static LongStream stream(long n) {
    if (n < 1) {
      throw new IllegalArgumentException(EXCEPTION_NATURAL_NUMBER_REQUIRED);
    }
    return recurse(n, LongStream.empty());
  }

  public static void main(String[] args) {
    LongStream.range(1, 11)
        .mapToObj(HailStorm::stream)
        .map(LongStreamUtilities::toString)
        .peek(System.out::println)

        // Make sure all elements are traversed
        .filter(n -> false)
        .findAny();
  }
}
