package edu.psu.presenations.sequences;

import java.util.function.LongSupplier;
import java.util.stream.LongStream;

import edu.psu.presenations.utilities.LongStreamUtilities;

public class Fibonacci {

  private class Supplier implements LongSupplier {

    long n = 0;
    long nPlusOne = 1;

    @Override
    public long getAsLong() {
      long output = n;
      n = nPlusOne;
      nPlusOne = output + n;
      return output;
    }

  }

  private Fibonacci() {
  }

  public static LongStream stream() {
    return LongStream.generate((new Fibonacci()).new Supplier());
  }

  public static void main(String[] args) {
    System.out.println(LongStreamUtilities.toString(
        Fibonacci.stream()
            .limit(10)
        ));
  }
  
}
