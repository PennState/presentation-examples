package edu.psu.presenations.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/** 
 * Extract all of the odd words from the standard linux words file
 * @author shawn
 */
public class OddWords
{
  public static void main(String[] args) throws IOException
  {
    List<String> oddWords = Files.lines(Paths.get("/usr/share/dict/words"))
                                             .filter(s -> s.length() % 2 != 0)
                                             .collect(Collectors.toList());
    
    System.out.println("There are " + oddWords.size() + " odd words");
  }
}
