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
public class DarterFish extends Fish
{
     
     // Constructors
    
    /** Constructs a fish at the specified location in a given environment.
     *  The Fish is assigned a random direction and random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     **/
    public DarterFish(Grid env, Location loc)
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
    public DarterFish(Grid env, Location loc, Direction dir)
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
    public DarterFish(Grid env, Location loc, Direction dir, Color col)
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
      //Dart two ahead
        //ArrayList<Location> emptyNbrs = emptyNeighbors();
         
      // Find the location one ahead, since fish do not move backwards.
        Direction fowardDir = direction();
        Location locationAhead = grid().getNeighbor(location(),fowardDir);
        
       if( grid().isEmpty(locationAhead) )
       {
              Location locationTwoAhead = grid().getNeighbor(locationAhead,fowardDir);
              if(grid().isEmpty(locationTwoAhead))
                  return locationTwoAhead;
              else
                  return locationAhead;
        }
            else 
                return location();
       }
    
      // /** Moves this fish in its environment.
     // **/
    // protected void move()
    // {
        // // Find a location to move to.
        // Debug.print("Fish " + toString() + " attempting to move.  ");
        // Location nextLoc = nextLocation();

        // // If the next location is different, move there.
        // if ( ! nextLoc.equals(location()) )
        // {
            // // Move to new location.
            // Location oldLoc = location();
            // changeLocation(nextLoc);

            // // Update direction in case fish had to turn to move.
            // Direction newDir = grid().getDirection(oldLoc, nextLoc);
            // changeDirection(newDir);
            // Debug.println("  Moves to " + location() + direction());
        // }
        // else
        // {
            // this.changeDirection(direction().reverse());
            // Debug.println(" Change direction.");
        // }
    // }
    protected void generateChild (Location loc){
        DarterFish child = new DarterFish(grid(), loc);
    }
    }  
    

