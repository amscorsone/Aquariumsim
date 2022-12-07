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
 * Write a description of class simpleFish here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class slowFish extends Fish
{

    protected static final double defaultProbOfMoving = 6.0 / 10.0;

    //Instance Variables 
    private double probOfMoving; 

    // Constructors

    /** Constructs a slowfish at the specified location 
     * in a given environment.
     **/
    public slowFish(Grid env, Location loc)
    {
        this(env, loc, env.randomDirection(), Color.RED);
    }

    /** Constructs a slowfish
     **/
    public slowFish(Grid env, Location loc, Direction dir)
    {
        // Construct and initialize to red
        this(env, loc, dir, Color.RED);
    }

    /** Constructs a slowfish
     **/
    public slowFish(Grid env, Location loc, Direction dir, Color col)
    {
        // Construct and initalize
        super(env, loc, dir, col); 

        // Defined the likely hood of moving
        this.probOfMoving = 4/5;

    }
    
    /** Finds this fish's next location.
     *  A fish may move to any empty adjacent locations except the one
     *  behind it (fish do not move backwards).  If this fish cannot
     *  move, <code>nextLocation</code> returns its current location.
     *  @return    the next location for this fish
     **/
    protected Location nextLocation()
    {
        // Get list of neighboring empty locations.

        RandNumGenerator randNumGen = RandNumGenerator.getInstance();
        if ( randNumGen.nextDouble() < this.probOfMoving)
            return super.nextLocation();
        else 
        {
            Debug.print("SlowFish" + this.toString() + 
                "not attempting to move");
            return this.location();
        }
    }

    protected void generateChild (Location loc){
        slowFish child = new slowFish(grid(), loc);
    }
}

