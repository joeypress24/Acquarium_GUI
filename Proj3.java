import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The Proj3 class houses the main method.
@author Press, Joey.
*/

public class Proj3
{
  public static void main(String[] args)
  {
    // create a FishTank object
    FishTank a1 = new FishTank(); // the overall fish tank
    a1.setTitle("Press, Joseph m235034");
    a1.setPreferredSize(new Dimension(600,600));

    a1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // have it close on exit
    a1.setLocation(100,100); // have it start not in top left to avoid glitch

    a1.pack(); // pack the components
    a1.setVisible(true);

  }

}
