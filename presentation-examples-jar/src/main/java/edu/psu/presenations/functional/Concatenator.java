package edu.psu.presenations.functional;

import javax.validation.constraints.NotNull;

@FunctionalInterface
public interface Concatenator<T>
{
  public T concat(@NotNull T t1, @NotNull T t2);
}
