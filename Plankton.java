import java.util.Random;

/**
The purpose of the Plankton class is to define the attributes of a plankton object.
@author Press, Joey.
*/
public class Plankton extends SeaCreature {

  private int depth;
  private int stepCounter = 0;

  // priority determines the "heirarchy" of killing
  private final int priority = 3;

/**
The Plankton constructor creates a new Plankton object.
@param x being the x coordinate.
@param y being the y coordinate.
@param xV being the x velocity
@param yV being the y velocity
*/
  public Plankton(int x, int y, int xV, int yV)
  {
    super(x, y, xV, yV, 5, 5, "plankton.png");

    //calculate the random depth to which the plankton will sink
    Random rand = new Random();
    this.depth = rand.nextInt(435); // int betweeen 0 and 435 (440 max)

  }

/**
move() defines how the plankton moves- in a vertical line downward to a specified
depth.
*/
  public void move()
  { // plankton object only moves down
    if(this.stepCounter <= depth)
    {
      y = y+1;
      this.stepCounter++;
    }
    //update the rectangle so it matches the animal
    setLocation(x, y);
  }

/**
Alive() simply allows other classes to know if the Plankton is alive.
@return boolean representing whether or not the Plankton is alive.
*/
  public boolean alive()
  {
    return true;
  }

/**
the getName() method is responsible for returning the name of the object.
@return String representing the name of the animal.
*/
  public String getName()
  {
    return "plankton";
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
    // do nothing because plankton doesn't have health
  }

/**
A get method to find the health of the animal.
@return int representing health.
*/
  public int getHealth()
  {
    return -1;
  }

/**
The makeImmortal() method is makes the object immortal to death in any form.
*/
  public void makeImmortal()
  {
    //plankton can't be immortal!
  }

/**
The addHealth() method overloads another one and allows the user to add a specified
amount of health to the object.
@param num representing the amount of health to be added.
*/
  public void addHealth(int num)
  {
    //plankton don't have health
  }

/**
This allows other classes to reset the stepCounter to avoid some crashes and errors.
*/
  public void resetStepCounter()
  {
    // plankton don't need to change speed
  }
}
