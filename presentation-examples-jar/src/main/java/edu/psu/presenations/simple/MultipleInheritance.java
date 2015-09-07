package edu.psu.presenations.simple;

import edu.psu.presenations.defaultabstract.Orientable;
import edu.psu.presenations.defaultabstract.Turnable;

public class MultipleInheritance implements Orientable, Turnable
{
  public static void main(String[] args)
  {
    MultipleInheritance twd = new MultipleInheritance();
    
    twd.rotate();
    twd.turnLeft();
  }
  
  @Override
  public void rotate()
  {
     System.out.println("MultipleInheritance.rotate");
  }
}
