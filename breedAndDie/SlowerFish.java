
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
public class SlowerFish extends slowFish
{

    //Instance Variables 
    private double probOfMoving; 
    private double probOfTurning;

    // Constructors

    /** Constructs a slowfish at the specified location 
     * in a given environment.
     **/
    public SlowerFish(Grid env, Location loc)
    {
        this(env, loc, env.randomDirection(), Color.WHITE);
    }

    /** Constructs a slowfish
     **/
    public SlowerFish(Grid env, Location loc, Direction dir)
    {
        // Construct and initialize to red
        this(env, loc, dir, Color.WHITE);
    }

    /** Constructs a slowfish
     **/
    public SlowerFish(Grid env, Location loc, Direction dir, Color col)
    {
        // Construct and initalize
        super(env, loc, dir, col); 

        // Defined the likely hood of moving
        this.probOfMoving = 1/5;
        this.probOfTurning = 3/5;
    }
    protected Location nextLocation(){
        
        // RandNumGenerator randNumGen = RandNumGenerator.getInstance();
        // if ( randNumGen.nextDouble() < this.probOfMoving && randNumGen.nextDouble() < this.probOfTurning )
            // return super.nextLocation();
        // else 
        // {
            // Debug.print("SlowFish" + this.toString() + 
                // "not attempting to move");
            // return this.location();
        // }
        Direction turnRight = direction().toRight();
        Location locationRight = grid().getNeighbor(location(),turnRight);
        
        RandNumGenerator randNumGen = RandNumGenerator.getInstance();
          if( randNumGen.nextDouble() < this.probOfTurning && randNumGen.nextDouble() 
          < this.probOfMoving)
              if(grid().isEmpty(locationRight))
                  return locationRight; 
         
           return location(); 
    }
 

    protected void generateChild (Location loc){
        SlowerFish child = new SlowerFish(grid(), loc);
    }
}

