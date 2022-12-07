import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.Direction;
import edu.kzoo.util.Debug;
import edu.kzoo.util.NamedColor;
import edu.kzoo.util.RandNumGenerator;


/**
 *  Grid-Based Marine Biology Simulation Program:<br>
 *
 *  A <code>???</code> object represents a ....
 *
 *  @author ???
 *  @version ???
 **/

public class whiteFish extends Fish
{
    // Class Variables: Shared among ALL objects of this class

    // Instance Variables: Encapsulated data for EACH object of this class
    int age; 

  // Constructors

     /** Constructs a fish at the specified location in a given environment.
     *  The Fish is assigned a random direction and random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     **/
    public whiteFish(Grid env, Location loc)
    {
        this(env, loc, env.randomDirection(), NamedColor.WHITE);
    }

    /** Constructs a fish at the specified location and direction in a
     *  given environment.  The Fish is assigned a random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     *  @param dir    direction the new fish is facing
     **/
    public whiteFish(Grid env, Location loc, Direction dir)
    {
        this(env, loc, dir, NamedColor.WHITE);
    }

    /** Constructs a fish of the specified color at the specified location
     *  and direction.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     *  @param dir    direction the new fish is facing
     *  @param col    color of the new fish
     **/
    public whiteFish(Grid env, Location loc, Direction dir, Color col)
    {
        super(env, loc, dir, NamedColor.WHITE);    // puts object at location myLoc in environment
       this.age = RandNumGenerator.getInstance().nextInt(20);
    }

  // Accessor (or Observer)  methods

    /** Returns a string representing key information about this fish.
     *  @return  a string indicating the fish's ID, location, and direction
     **/
    public String toString()
    {
        return super.toString() + "<(" + this.age + ")";
    }

      /** Acts for one step in the simulation.
     **/
    public void act()
    {
        // Make sure fish is alive and well in the environment -- fish
        // that have been removed from the environment shouldn't act.
        super.act();
        this.age++;
    }
    protected void  generateChild (Location loc){
       whiteFish child = new whiteFish(grid(), loc);
    }

}
