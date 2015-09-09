package edu.psu.presenations.lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelTests
{

  public static void main(String[] args) throws IOException
  {
     List<String> words = Files.lines(Paths.get("/usr/share/dict/words"))
                                  .collect(Collectors.toList());
     
     Instant now = Instant.now();
     int stupidSum = words.stream().sorted() 
                                      .sorted((a,b) -> b.compareTo(a))
                                      .mapToInt(String::length)
                                      .sorted()
                                      .sum();
     Instant done = Instant.now();
     
     System.out.println((done.getNano() - now.getNano()));
     
     now = Instant.now();
     stupidSum = words.parallelStream().sorted() 
                         .sorted((a,b) -> b.compareTo(a))
                         .mapToInt(String::length)
                         .sorted()
                         .sum();
     done = Instant.now();
     
     System.out.println((done.getNano() - now.getNano()));
  }

}
