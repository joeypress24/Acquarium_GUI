import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The purpose of AdvancedListener class is to implement ActionListener to allow for
the user to modify the advanced controls panel.
@author Press, Joey
*/
public class AdvancedListener implements ActionListener {

  private JSlider selector;
  private Tank tank;
  private JComboBox options;

/**
The AdvancedListener constructor is responsible for initiating an AdvancedListener
object.
@param tank representing the tank, linking the class to tank.
@param options representing the JComboBox that contains the options the user
can select
@param selector representing the JSlider that the user chooses to indicate the
amount of change to be added.
*/
  public AdvancedListener(Tank tank, JComboBox options, JSlider selector)
  {
    this.selector = selector;
    this.tank = tank;
    this.options = options;

    // set up the selector
    selector.setLabelTable(selector.createStandardLabels(25, 0));
    selector.setPaintLabels(true);
  }

/**
The actionPerformed method is responsible for executing the proper code when the
user makes a selection in the method.
@param e representing the respective ActionEvent object.
*/
  public void actionPerformed(ActionEvent e)
  {
    int value = selector.getValue();
    int max = selector.getMaximum();

    String field = (String)options.getSelectedItem();
    // System.out.println("Field: " + field);
    // System.out.println(value);

    // test for immortality field
    if(field.equals("Fish immortality") && value > 0)
    {
      tank.setImmortal("fish");
    }
    if(field.equals("Lionfish immortality") && value > 0)
    {
      tank.setImmortal("lionfish");
    }
    if(field.equals("Shark immortality") && value > 0)
    {
      tank.setImmortal("shark");
    }

    // test for starvation field
    if(field.equals("Shark starvation"))
    {
      tank.addHealth("shark", value);
    }
    if(field.equals("Lionfish starvation"))
    {
      tank.addHealth("lionfish", value);
    }
    if(field.equals("Fish starvation"))
    {
      tank.addHealth("fish", value);
    }

    // test for speed field
    if(field.equals("Shark speed"))
    {
      //System.out.println("Shark speed set");
      tank.setThreshold("shark", value);
    }
    if(field.equals("Fish speed"))
    {
      //  System.out.println("fish speed set");
      tank.setThreshold("fish", value);
    }
    if(field.equals("Lionfish speed"))
    {
      //  System.out.println("lionfish speed set");
      tank.setThreshold("lionfish", value);
    }
  }
}
