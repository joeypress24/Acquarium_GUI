import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.Random;

/**
The purpose of the Shark class is extend SeaCreature to add the functionality of
a Shark.
@author Press, Joey
*/
public class Shark extends SeaCreature {

  private int stepCounter = 0;

  private int metabolism;
  private int health;
  private boolean isAlive = true;

  // priority determines the "heirarchy" of killing
  private final int priority = 1;

/**
The Shark constructor is responsible for initializing the Shark object with the
necessary fields.
@param x being the x coordinate.
@param y being the y coordinate.
@param xV being the x velocity
@param yV being the y velocity
@param metabolism acting as the factor that influences the decrease in health
@param health which is increased when eating and kills the animal if it dies.
*/
  public Shark(int x, int y, int xV, int yV, int metabolism, int health)
  {
    super(x, y, xV, yV, 50, 50, "shark.png");
    xScale = xScale*-1; // scale needs to start inverted because of image
    this.health = health;
    this.metabolism = metabolism;
  }

/**
The move() method is responsible for moving the Shark object in the specified
pattern.
*/
  public void move()
  {
    stepCounter++;
    if(stepCounter == getThreshold())
    {
      stepCounter = 0;
      if( (x+xVelocity < 550) && (x+xVelocity > 50))
      {
        x = x + xVelocity;
      }
      else
      {
        xVelocity = xVelocity*-1;
        xScale = xScale*-1; // flip the image when direction is changed
        x = x + xVelocity;
      }

      if( (y+yVelocity < 400) && (y+yVelocity > 200))
      {
        y = y + yVelocity;
      }
      else
      {
        yVelocity = yVelocity*-1;
        y = y + yVelocity;
      }

      //update the rectangle so it matches the fish
      setLocation(x, y);
    }

    health -= metabolism;
    if(health == 0)
    {
      isAlive = false;
    }

  }

/**
The alive() method simply allows other classes to know if the animal has been
killed.
@return boolean representing whether or not the animal is alive.
*/
  public boolean alive()
  {
    return isAlive;
  }

/**
the getPriority() method is responsible for returning the priority of the animal
in the ecosystem.
@return int representing the priority
*/
  public int getPriority()
  {
    return this.priority;
  }

/**
the getName() method is responsible for returning the name of the object.
@return String representing the name of the animal.
*/
  public String getName()
  {
    return "shark";
  }

/**
The addHealth() method increases the health of the fish when it eats.
*/
  public void addHealth()
  {
    this.health = this.health+500;
  }

/**
The makeImmortal() method is makes the object immortal to death in any form.
*/
  public void makeImmortal()
  {
    this.metabolism = 0; // won't starve
  }

/**
The addHealth() method overloads another one and allows the user to add a specified
amount of health to the object.
@param num representing the amount of health to be added.
*/
  public void addHealth(int num)
  {
    this.health += num;
    super.makeLarger();
  }

/**
A get method to find the health of the animal.
@return int representing health.
*/
  public int getHealth()
  {
    return this.health;
  }

/**
resetStepCounter() allows other classes to reset the stepCounter before doing
something that would cause the program to crash.
*/
  public void resetStepCounter()
  {
    this.stepCounter = 0;
  }
}
