import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The StartListener class is responsbile for listening to the button that allows
the user to start and stop the program.
@author Press, Joey.
*/
public class StartListener implements ActionListener {

  private JButton start;
  private Tank tank;

/**
The StartListener() constructor is responsible for instantiating a new
StartListener object.
@param tank representing the tank that is being started and stopped.
@param start representing the JButton object that is going to be pressed.
*/
  public StartListener(Tank tank, JButton start)
  {
    this.tank = tank;
    this.start = start;
  }

/**
The ActionPerformed method is responsible for pausing and unpausing the tank
when the user presses the button.
@param e representing the ActionEvent object corresponding to this button click.
*/
  public void actionPerformed(ActionEvent e)
  {
    tank.pauseUnpause();
  }
}
