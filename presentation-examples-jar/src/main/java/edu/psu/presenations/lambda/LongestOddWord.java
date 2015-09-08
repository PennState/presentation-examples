package edu.psu.presenations.lambda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Extract all of the odd words from the standard linux words file
 * 
 * @author shawn
 */
public class LongestOddWord
{
  public static void main(String[] args) throws IOException
  {
    //Iteration
    FileInputStream fis = new FileInputStream(new File("/usr/share/dict/words"));

    BufferedReader br = new BufferedReader(new InputStreamReader(fis));

    String currentLine = null;
    int length = -1;
    String word = null;

    while ((currentLine = br.readLine()) != null)
    {
      if (currentLine.length() > length)
      {
        length = currentLine.length();
        word = currentLine;
      }
    }

    br.close();

    System.out.println("Longest word = " + word + " at " + length + " characters");

    //Functional
    String longest = Files.lines(Paths.get("/usr/share/dict/words"))
                          .filter(s -> s.length() % 2 != 0)
                          .reduce("", (a, b) -> (b.length() > a.length()) ? b : a);

    System.out.println("Longest word = " + longest + " at " + longest.length() + " characters");

  }
}
