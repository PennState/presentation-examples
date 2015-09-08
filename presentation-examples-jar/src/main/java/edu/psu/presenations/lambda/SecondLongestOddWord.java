package edu.psu.presenations.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Extract all of the odd words from the standard linux words file
 * 
 * @author shawn
 */
public class SecondLongestOddWord
{
  public static void main(String[] args) throws IOException
  {
    //Functional
    String longest = Files.lines(Paths.get("/usr/share/dict/words"))
                          .sorted((a,b)-> Integer.compare(b.length(), a.length()))
                          .filter(s -> s.length() % 2 != 0)
                          .skip(1)
                          .findFirst()
                          .orElse("wah wah wah waaaaaaaaah");

        System.out.println("Second Longest word = " + longest + " at " + longest.length() + " characters");

  }
}
