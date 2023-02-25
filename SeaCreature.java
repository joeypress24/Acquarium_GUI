import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.Random;
import java.awt.event.*;

/**
The purpose of the SeaCreature class is to act as the parent class to the
variety of animals that live in the tank ecosystem.
@author Press, Joey
*/
public abstract class SeaCreature extends Rectangle implements MouseListener {

  protected int xVelocity;
  protected int yVelocity;
  protected int x;
  protected int y;
  protected int xScale;
  private int yScale;
  protected int threshold = 3; // sets the speed

  private BufferedImage img;

  private boolean clickStatus = false;

  // a field representing direction, bounds: 0 <= direction <= 7
  protected int direction = 0;

/**
The SeaCreature constructor is responsible for initializing a SeaCreature
object, which carries the common attributes of the child animals.
@param x being the x coordinate.
@param y being the y coordinate.
@param xV being the x velocity
@param yV being the y velocity
@param xScale representing the xScale of the image.
@param yScale representing the yScale of the image.
@param fname representing the name of the .jpg or .png file.
*/
  public SeaCreature(int x, int y, int xV, int yV, int xScale, int yScale, String fname)
  {
    super(x, y, xScale, yScale);
    // initialize the speed and position variables
    this.x = x;
    this.y = y;
    this.xVelocity = xV;
    this.yVelocity = yV;
    this.xScale = xScale; // initialize the x and y scale
    this.yScale = yScale;

    // initialize the bufferedImage
    this.img = null;
    try {
      img = ImageIO.read(new File(fname));
    } catch (IOException e) {}
  }

/**
The setDirection method is responsible for setting the private direction field
of this instance to a new value. The method must account for the changes from
North-West to North and vice versa.
@param dir representing the random direction, -1 meaning go left, 0 meaning
go straight, and 1 meaning turn right. There are also direction changes with a
magnitude of 2 for "hard" turns, used for BlueDot and RedDot.
*/
  protected void setDirection(int dir)
  {
    // dir shoult be -1, 0, or 1, or -2, 0, or 2 (for Blue and Red dot)
    this.direction += dir;
    if(this.direction < 0)
    {
      this.direction = 6;
      if(dir == -1) // correct for GreenDot
      {
        this.direction++;
      }
    }
    else if(this.direction > 7)
    {
      this.direction = 0;
    }
  }

/**
Get method returning the Xvalue.
@return int the X value of the animal.
*/
  public int getThisX()
  {
    return this.x;
  }

/**
Get method of the Yvalue.
@return int representing the Y value
*/
  public int getThisY()
  {
    return this.y;
  }

/**
Get method for the xScale
@return int representing the xScale of the image.
*/
  public int getXScale()
  {
    return this.xScale;
  }

/**
Get method for the yScale
@return int representing the yScale of the image.
*/
  public int getYScale()
  {
    return this.yScale;
  }

/**
This method makes the image larger when the animal eats.
*/
  public void makeLarger()
  {
    this.yScale+=5;
    if(this.xScale < 0)
    {
      this.xScale -= 5;
    }
    else
    {
      this.xScale += 5;
    }
  }

/**
Get method for the BufferedImage object.
@return BufferedImage representing the BufferedImage object.
*/
  public BufferedImage getImage()
  {
    return this.img;
  }

/**
setThreshold() is responsible for changing the speed when the user requests it.
@param num representing the JSlider value when the user tries to change the
speed.
*/
  public void setThreshold(int num)
  {
    if(num >= 75)
    {
      this.threshold = 1;
    }
    else if(num < 75 && num >= 50)
    {
      this.threshold = 2;
    }
    else if(num < 50)
    {
      this.threshold = 3;
    }
  }

/**
Get method for the threshold, or speed of the object.
@return int representing the threshold.
*/
  public int getThreshold()
  {
    return this.threshold;
  }

/**
getClickStatus() loops through the SeaCreatures and checks if they have been
clicked on, alerting the mouseclicklistener class that an animal has been selected.
@return boolean representing whether or not the fish is being clicked.
*/
  public boolean getClickStatus()
  {
    return this.clickStatus;
  }

  // deal with the abstract mouseclick methods
  public void mouseClicked(MouseEvent e) {
    this.clickStatus = !this.clickStatus;
  }

  public void mouseEntered(MouseEvent e)  {
  //  System.out.println("FUN");
  }

  public void mouseExited(MouseEvent e)   {
  //  System.out.println("FUN");
  }

  public void mousePressed(MouseEvent e)  {
  //  System.out.println("FUN");
  }

  public void mouseReleased(MouseEvent e) {
    //System.out.println("FUN");
  }

  // define abstract methods required by children to fill out.
  public abstract void move();
  public abstract int getPriority();
  public abstract boolean alive();
  public abstract String getName();
  public abstract void addHealth();
  public abstract void makeImmortal();
  public abstract void addHealth(int num);
  public abstract void resetStepCounter();
  public abstract int getHealth();
}
