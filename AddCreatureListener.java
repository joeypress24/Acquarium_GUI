import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
The purpose of the AddCreatureListener class is to allow for the user to add a new
creature to the tank.
@author Press, Joey
*/
public class AddCreatureListener implements ActionListener {
    private JComboBox addCreature;
    private Tank tank;

/**
The AddCreatureListener constructor initializes a new listener.
@param tank representing the tank object, linking the class to the tank.
@param addCreature allowing the listener to access the JComboBox.
*/
    public AddCreatureListener(Tank tank, JComboBox addCreature)
    {
      this.tank = tank;
      this.addCreature = addCreature;
    }

/**
The actionPerformed method is responsible for executing the proper code when the
user makes a selection in the method.
@param e representing the respective ActionEvent object.
*/
    public void actionPerformed(ActionEvent e)
    {
      // add the requested animal to the tank
      if(addCreature.getSelectedItem().equals("Fish"))
      {
        tank.addFish();
      }
      if(addCreature.getSelectedItem().equals("Shark"))
      {
        tank.addShark();
      }
      if(addCreature.getSelectedItem().equals("Lionfish"))
      {
        tank.addLionFish();
      }

      addCreature.setSelectedItem(0); // reset the JComboBox
    }
}
