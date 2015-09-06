package edu.psu.presenations.defaultabstract;

public interface Turnable
{
  default void rotate()
  {
     System.out.println("Turnable.rotate");
  }
  
  default void turnLeft()
  {
    System.out.println("Turnable.turnLeft");
  }
}
