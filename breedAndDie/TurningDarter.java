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
 * Write a description of class TurningDarter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TurningDarter extends Fish
{
    // instance variables - replace the example below with your own
    
     private double probOfTurning;
     // Constructors
    
    /** Constructs a fish at the specified location in a given environment.
     *  The Fish is assigned a random direction and random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     **/
    public TurningDarter(Grid env, Location loc)
    {
        this(env, loc, env.randomDirection(), NamedColor.getRandomColor());
    }

    /** Constructs a fish at the specified location and direction in a
     *  given environment.  The Fish is assigned a random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     *  @param dir    direction the new fish is facing
     **/
    public TurningDarter(Grid env, Location loc, Direction dir)
    {
        this(env, loc, dir, NamedColor.getRandomColor());
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
    public TurningDarter(Grid env, Location loc, Direction dir, Color col)
    {
        super(env, loc, dir, col);    // puts object at location myLoc in environment
       
        // Defined the likely hood of moving
        this.probOfTurning = 1/100;
    }
    
    protected Location nextLocation(){
        Direction rightDir = direction().toRight();
        Location locationRight = grid().getNeighbor(location(),rightDir);
        Direction leftDir = direction().toLeft();
        Location locationLeft = grid().getNeighbor(location(),leftDir);
        RandNumGenerator randNumGen = RandNumGenerator.getInstance();
        if( grid().isEmpty(locationRight) ){
        return locationRight;
        //&& randNumGen.nextFloat() < this.probOfTurning
    }
    else return location();
    //super.nextLocation();
    

}
    
}
