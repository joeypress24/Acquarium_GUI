import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
The purpose of the FishTank class is to create appropriately sized panels for the
tank and toolbar.
@author Press, Joey.
*/
public class FishTank extends JFrame {

  private JButton startButton;
  private Tank tank;
  private ToolBar tools;

/**
The constructor for Acquarium takes in no parameters and is responsible for
building an Acquarium JFrame.
*/
  public FishTank()
  {
    //make a panel for the botton
    JPanel bottom = new JPanel(new FlowLayout());
    // make a tank to go in the bottom of the GUI
    Tank tank = new Tank();
    bottom.add(tank);
    tank.setPreferredSize(new Dimension(600,500));

    // make a panel for the top
    JPanel top = new JPanel(new FlowLayout());
    // create a toolbar
    ToolBar tools = new ToolBar(tank);
    top.add(tools);
    tools.setPreferredSize(new Dimension(600,75));
    tools.updateUI();

    this.add(top, BorderLayout.NORTH);
    this.add(bottom, BorderLayout.CENTER);
    this.pack();

    this.tools = tools;
    this.tank = tank;
  }

}
