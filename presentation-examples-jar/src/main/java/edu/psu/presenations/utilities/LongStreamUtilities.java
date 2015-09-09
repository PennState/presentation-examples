package edu.psu.presenations.utilities;

import java.util.stream.LongStream;

public class LongStreamUtilities {

  // Hide the default constructor
  private LongStreamUtilities() {
  }

  /**
   * Consumes all the values provided by the passed LongStream, displaying them
   * as an array of values (on a single line).
   * 
   * @param ls
   *          the LongStream.
   * @return a String representation of the LongStream.
   */
  public static String toString(LongStream ls) {
    StringBuilder sb = new StringBuilder("[");
    ls
        .peek(sb::append)
        .peek(n -> sb.append(", "))
        .filter(n -> false)
        .findAny();
    String output = sb.substring(0, sb.length() - 2);
    return output + "]";
  }

}
