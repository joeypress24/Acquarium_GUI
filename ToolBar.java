import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The ToolBar class sets up the toolbar part of the GUI, which allows the user to
interact with the fishtank. 
@author Press, Joey
*/
public class ToolBar extends JPanel implements Runnable {

  private Tank tank; // we need this to link the ToolBar to the Tank

  private JTextArea t; // used to update the TextField in the toolbar on click

  // an array to hold the "options" for the JComboBox
  private static final String[] comboArray = {"Select creature to add", "Shark", "Fish", "Lionfish"};
  private static final String[] optArray = {"Select option", "Shark starvation", "Fish starvation",
   "Lionfish starvation", "Shark immortality", "Fish immortality", "Lionfish immortality",
    "Shark speed", "Fish speed", "Lionfish speed"};

/**
The ToolBar constructor is responsible for creating a ToolBar object.
@param tank representing the tank that has already been created.
*/
  public ToolBar(Tank tank)
  {
    this.tank = tank;
    // make a button

    JButton start = new JButton("start/pause");
    start.addActionListener(new StartListener(tank, start));

    JButton feed = new JButton("feed");
    feed.addActionListener(new FeedListener(tank, feed)); // add feed button listener

    JComboBox addCreature = new JComboBox(comboArray);
    addCreature.addActionListener(new AddCreatureListener(tank, addCreature));

    JPanel advancedControls = new JPanel();
    JComboBox options = new JComboBox(optArray);
    advancedControls.add(options);
    JSlider selector = new JSlider();
    advancedControls.add(selector);
    options.addActionListener(new AdvancedListener(tank, options, selector));

    JTextArea tf = new JTextArea();
    this.t = tf;
    // start a thread to constantly check if the user clicked
    Thread t = new Thread(this);
    t.start();

    this.add(start);
    this.add(feed);
    this.add(addCreature);
    this.add(advancedControls);
    this.add(tf);

    this.setBackground(Color.blue);
  }

/**
The run() method is responsible for continuously checking for mouse clicks and
responding appropriately to one.
*/
  public void run()
  {
    while(true)
    {
      try{
        Thread.sleep(200);
      }
      catch(Exception e) {}


      if(tank.isClicked())
      {
        //System.out.println("HERE");
        int health = tank.getHealthFromSelected();
        int speed = tank.getSpeedFromSelected();
        int priority = tank.getPriorityFromSelected();
        this.t.setText("health: "+health+" speed: "+speed+" priority: " + priority);
      }
      else
      {
        this.t.setText(""); // empty the textbox if no creature is selected
      }
    }
  }
}
