// Class Fish
//
// Author: 
// This class is based on the College Board's Fish class,
// as allowed by the GNU General Public License.
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

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
 *  A <code>Fish</code> object represents a fish in the Marine Biology
 *  Simulation. Each fish has a unique ID, which remains constant
 *  throughout its life.  A fish also maintains information about its
 *  location and direction in the environment.
 *
 *  @author Amalia Scorsone 
 *  @version 25 April 2019
 **/

public class Fish extends GridObject
{
    // Class Variable: Shared among ALL fish
    private static int nextAvailableID = 1;   // next avail unique identifier

    // Instance Variables: Encapsulated data for EACH fish
    private int myId;                  // unique ID for this fish
    private Direction myDir;           // fish's direction
    private Color myColor;             // fish's color
    protected double probOfBreeding;    //
    protected int probOfDying;      // 1 / (probOfDying) chanc
    int slow = 0;
    double probDouble = 0;
  // constructors and related helper methods

    /** Constructs a fish at the specified location in a given environment.
     *  The Fish is assigned a random direction and random color.
     *  (Precondition: parameters are non-null; <code>loc</code> is valid
     *  for <code>env</code>.)
     *  @param env    environment (grid) in which fish will live
     *  @param loc    location of the new fish in <code>env</code>
     **/
    public Fish(Grid env, Location loc)
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
    public Fish(Grid env, Location loc, Direction dir)
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
    public Fish(Grid env, Location loc, Direction dir, Color col)
    {
        super(env, loc);    // puts object at location myLoc in environment
        this.myId = nextAvailableID;
        this.nextAvailableID++;
        this.myDir = dir;
        this.myColor = col;
        // intiilziation of new vairbles
            this.probOfBreeding = 1.0/7.0; // 1 in 7 change of breeding
            this.probOfDying = 5; // 1 in 5 of dying 
    }

  // accessor methods

  /** die method
     **/
    public void die()
    {
        this.removeFromGrid();
       
    }
    
    protected void generateChild (Location loc){
        Fish child = new Fish(grid(), loc);
        //child.COLOR; // get it to be the same color
         Debug.println(" New Fish created: " + child.toString());
    }
    
    /** Acts for one step in the sim 
     **/
    public boolean breed()
    {
        ArrayList<Location> empty = emptyNeighbors();
        this.probDouble = RandNumGenerator.getInstance().nextDouble();
        if(probDouble > probOfBreeding){
        return false;
        }
       if (empty.size() == 0){
            return false;
        }
        
        for (Location loc : empty){
            generateChild(loc);
        }
    
        return true;
}
    
    /** Returns this fish's ID.
     *  @return        the unique ID for this fish
     **/
    public int id()
    {
        return this.myId;
    }

    /** Returns this fish's color.
     *  @return        the color of this fish
     **/
    public Color color()
    {
        return this.myColor;
    }

    /** Returns this fish's direction.
     *  @return        the direction in which this fish is facing
     **/
    public Direction direction()
    {
        return this.myDir;
    }

    /** Returns a string representing key information about this fish.
     *  @return  a string indicating the fish's ID, location, and direction
     **/
    public String toString()
    {
        return id() + location().toString() + direction().toString();
    }

    
  // modifier method

    /** Acts for one step in the simulation.
     **/
    public void act()
    {
        // Make sure fish is alive and well in the environment -- fish
        // that have been removed from the environment shouldn't act.
        if ( !isInAGrid())
            return;
        
        if ( ! breed() )   
            move();
             
         
        this.slow = RandNumGenerator.getInstance().nextInt(probOfDying);
        if ( slow == 1)
          this.die();
       
        }


  // internal helper methods

    /** Moves this fish in its environment.
     **/
    protected void move()
    {
        // Find a location to move to.
         Debug.print("Fish " + toString() + " attempting to move.  ");
        Location nextLoc = nextLocation();

        // If the next location is different, move there.
        if ( ! nextLoc.equals(location()) )
        {
            // Move to new location.
            Location oldLoc = location();
            changeLocation(nextLoc);

            // Update direction in case fish had to turn to move.
            Direction newDir = grid().getDirection(oldLoc, nextLoc);
            changeDirection(newDir);
            Debug.println("  Moves to " + location() + direction());
        }
        else
            Debug.println("  Does not move.");
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
        ArrayList<Location> emptyNbrs = emptyNeighbors();

        // Remove the location behind, since fish do not move backwards.
        Direction oppositeDir = direction().reverse();
        Location locationBehind = grid().getNeighbor(location(),
                                                     oppositeDir);
        emptyNbrs.remove(locationBehind);
        Debug.print("Possible new locations are: " + emptyNbrs.toString());

        // If there are no valid empty neighboring locations, then we're done.
        if ( emptyNbrs.size() == 0 )
            return location();

        // Return a randomly chosen neighboring empty location.
        Random randNumGen = RandNumGenerator.getInstance();
        int randNum = randNumGen.nextInt(emptyNbrs.size());
        return (Location) emptyNbrs.get(randNum);
    }

    /** Finds empty locations adjacent to this fish.
     *  @return    an ArrayList containing neighboring empty locations
     **/
    protected ArrayList<Location> emptyNeighbors()
    {
        // Get all the neighbors of this fish, empty or not.
        ArrayList<Location> nbrs = grid().neighborsOf(location());

        // Figure out which neighbors are empty and add those to a new list.
        ArrayList<Location> emptyNbrs = new ArrayList<Location>();
        for ( Location loc : nbrs )
        {
            if ( grid().isEmpty(loc) )
                emptyNbrs.add(loc);
        }

        return emptyNbrs;
    }

    /** Modifies this fish's direction.
     *  @param  newDir    new direction value
     **/
    protected void changeDirection(Direction newDir)
    {
        // Change direction.
        myDir = newDir;
    }

}
