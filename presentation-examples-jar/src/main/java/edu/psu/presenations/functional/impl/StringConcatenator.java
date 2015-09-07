package edu.psu.presenations.functional.impl;

import javax.validation.constraints.NotNull;

import edu.psu.presenations.functional.Concatenator;

public class StringConcatenator implements Concatenator<String>
{
  @Override
  public String concat(@NotNull String t1, @NotNull String t2)
  {
    return t1 + t2;
  }
}
