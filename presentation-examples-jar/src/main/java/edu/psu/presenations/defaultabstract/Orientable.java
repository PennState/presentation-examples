package edu.psu.presenations.defaultabstract;

public interface Orientable
{
  default void rotate()
  {
    System.out.println("Orientable.rotate");
  }
}
