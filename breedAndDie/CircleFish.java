
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
 * Write a description of class turningDarter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CircleFish extends Fish
{
    // instance variables - replace the example below with your own
    private int x;

    /** Constructs a fish at the specified location in a given environment.
     *  The Fish is assigned a random direction and random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     **/
    public CircleFish(Grid env, Location loc)
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
    public CircleFish(Grid env, Location loc, Direction dir)
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
    public CircleFish(Grid env, Location loc, Direction dir, Color col)
    {
        super(env, loc, dir, col);    // puts object at location myLoc in environment
       
    }
    /** Finds this fish's next location.
     *  A fish may move to any empty adjacent locations except the one
     *  behind it (fish do not move backwards).  If this fish cannot
     *  move, <code>nextLocation</code> returns its current location.
     *  @return    the next location for this fish
     **/
    protected Location nextLocation()
    {
        Direction fowardDir = this.direction();
        Direction turnRight = direction().toRight();
        Location locationAhead = grid().getNeighbor(location(),fowardDir);
        Location locationRight = grid().getNeighbor(locationAhead,turnRight);
        
        if( grid().isEmpty(locationAhead)){
            if(grid().isEmpty(locationRight))
                  return locationRight;
              else
                  return locationAhead;
        }
        else{
            return super.nextLocation();
        }

            }
            
        protected void generateChild (Location loc){
       CircleFish child = new CircleFish(grid(), loc);
    }
}



