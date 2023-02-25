import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.Random;
/**
The purpose of the Fish class is to override methods in SeaCreature to allow for
the added functionality of a Fish animal.
@author Press, Joey
*/
public class Fish extends SeaCreature {

  private int stepCounter = 0;
  private int metabolism;
  private int health;
  private boolean isAlive = true;

  // priority determines the "heirarchy" of killing
  private int priority = 2;

  private ArrayList<Rectangle> rectangles;

/**
The Fish constructor iniatilizes a new fish with all the necessary data.,
@param x being the x coordinate.
@param y being the y coordinate.
@param xV being the x velocity
@param yV being the y velocity
@param metabolism acting as the factor that influences the decrease in health
@param health which is increased when eating and kills the animal if it dies.
*/
  public Fish(int x, int y, int xV, int yV, int metabolism, int health)
  {
    super(x, y, xV, yV, 50, 50, "fish.png");
    this.metabolism = metabolism;
    this.health = health;
  }

/**
Alive() simply allows other classes to know if the Fish is alive.
@return boolean representing whether or not the fish is alive.
*/
  public boolean alive()
  {
    return isAlive;
  }


/**
move() defines how the fish moves- at 45 degrees around the entire tank.
*/
  public void move()
  {
    stepCounter++;
    if(stepCounter == getThreshold())
    {
      if( (x+xVelocity < 550) && (x+xVelocity > 0))
      {
        x = x + xVelocity;
      }
      else
      {
        xVelocity = xVelocity*-1;
        xScale = xScale*-1; // flip the image when direction is changed
        //super.rotate(Math.PI);
        x = x + xVelocity;
      }

      if( (y+yVelocity < 350) && (y+yVelocity > 0))
      {
        y = y + yVelocity;
      }
      else
      {
        yVelocity = yVelocity*-1;
        y = y + yVelocity;
      }
      stepCounter = 0;
    }

    health = health - metabolism;
    if(health == 0)
    {
      isAlive = false;
    }
    //update the rectangle so it matches the fish
    setLocation(x, y);
  }

/**
the getName() method is responsible for returning the name of the object.
@return String representing the name of the animal.
*/
  public String getName()
  {
    return "fish";
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
The addHealth() method increases the health of the animal when it eats.
*/
  public void addHealth()
  {
    this.health = this.health+500;
    super.makeLarger();
  }

/**
The makeImmortal() method is makes the object immortal to death in any form.
*/
  public void makeImmortal()
  {
    this.priority = 1;
    this.metabolism = 0;
  }

/**
The addHealth() method overloads another one and allows the user to add a specified
amount of health to the object.
@param num representing the amount of health to be added.
*/
  public void addHealth(int num)
  {
    this.health += num;
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
This allows other classes to reset the stepCounter to avoid some crashes and errors.
*/
  public void resetStepCounter()
  {
    this.stepCounter = 0;
  }
}
