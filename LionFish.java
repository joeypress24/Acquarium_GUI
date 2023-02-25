import java.awt.geom.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import java.util.Random;
/**
The purpose of the LionFish class is to extend SeaCreature to add the functionality
of a new animal: the lionfish.
@author Press, Joey
*/
public class LionFish extends SeaCreature {

  private int stepCounter = 0;
  private int metabolism;
  private int health;
  private boolean isAlive = true;

  // class specific private variables
  private double goalX = 300;
  private double goalY = 300;
  private double r = 4;
  private double delta = 2;

  // priority determines the "heirarchy" of killing
  private int priority = 2;

/**
The LionFish constructor is responsible for initializing the LionFish object with
all of the necessary attributes.
@param x being the x coordinate.
@param y being the y coordinate.
@param xV being the x velocity
@param yV being the y velocity
@param metabolism acting as the factor that influences the decrease in health
@param health which is increased when eating and kills the animal if it dies.
*/
  public LionFish(int x, int y, int xV, int yV, int metabolism, int health)
  {
    super(x, y, xV, yV, 50, 50, "lionfish.png");
    this.metabolism = metabolism;
    this.health = health;
  }

/**
alive() returns true if the fish is alive.
@return boolean representing whether or not the animal is alive
*/
  public boolean alive()
  {
    return isAlive;
  }

/**
The move() method is responsible for moving the Lionfish object in the specified
pattern.
*/
  public void move()
  {
    stepCounter++;
    if(stepCounter == getThreshold())
    {
      if(x == (int)goalX && y == (int)goalY)
      {
        resetGoals();
      }
      if (Math.sqrt(Math.pow(goalY - y, 2) + Math.pow(goalX - x, 2)) < delta){
        x = (int)goalX;
        y = (int)goalY;
      } else {
        double a = Math.atan2(goalY - y, goalX - x);
        x += (int)(delta * Math.cos(a));
        y += (int) (delta * Math.sin(a));
      }
      if(goalX < x && xScale > 0)
      {
        xScale *= -1;
      }
      else if(goalX > x && xScale < 0)
      {
        xScale *= -1;
      }

      stepCounter = 0;

    }
    setLocation(x, y);
    health = health - metabolism;
    if(health == 0)
    {
      isAlive = false;
    }
  }

/**
The resetGoals() method is supporting the move() method by changing the "random"
point towards where the Lionfish will swim.
*/
  public void resetGoals()
  {
    Random rand = new Random();

    int tempX = (rand.nextInt(400-100)+100);

    int tempY = rand.nextInt(400-100)+100;

    goalX = tempX;
    goalY = tempY;
  //  System.out.println("goalX: " +goalX + " goalY: " + goalY);
  }

/**
the getName() method is responsible for returning the name of the object.
@return String representing the name of the animal.
*/
  public String getName()
  {
    return "lionfish";
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
The addHealth() method increases the health of the fish when it eats.
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
resetStepCounter() allows other classes to reset the stepCounter before doing
something that would cause the program to crash.
*/
  public void resetStepCounter()
  {
    this.stepCounter = 0;
  }

}
