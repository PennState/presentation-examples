package edu.psu.presenations.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
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
    
    Integer biggest = oddWords.stream()
                              .map(s -> s.length())
                              .max(Integer::compare)
                              .orElse(-1);
    
    System.out.println("And the biggest is " + biggest + " characters");
    
    Optional<Integer> biggest2 = oddWords.stream()
                                         .map(s -> s.length())
                                         .max(Integer::compare);
    
    System.out.println("And the biggest2 is " + biggest2.orElse(-1) + " characters");
    
    //TODO - What is the the longest word
    
    for (int i = 0; i < 1000; ++i)
    {
      Optional<String> wordWithExe = Files.lines(Paths.get("/usr/share/dict/words"))
                                          .parallel()
                                          .filter(s -> s.contains("exe"))
                                          .findAny();
      
      System.out.println(wordWithExe.get());
    }
                                      
  }
}
