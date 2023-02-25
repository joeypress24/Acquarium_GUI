import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The purpose of the FeedListener class is to implement ActionListener to allow the
user to add a plankton to the tank.
@author Press, Joey
*/
public class FeedListener implements ActionListener {

  private JButton start;
  private Tank tank;

/**
The FeedListener constructor initializes a new listener.
@param tank representing the tank object, linking the class to the tank.
@param start the JButton object that is being pressed.
*/
  public FeedListener(Tank tank, JButton start)
  {
    this.tank = tank;
    this.start = start;
  }

/**
The actionPerformed() method is called when the user performs the action.
@param e representing the ActionEvent object of this action.
*/
  public void actionPerformed(ActionEvent e)
  {
    tank.addPlankton();
  }
}
