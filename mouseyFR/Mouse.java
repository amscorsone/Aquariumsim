// Class: Cheese
//
// Author: Alyce Brady
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

import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.NamedColor;
import java.util.ArrayList;
import java.util.Random;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.util.Debug;


/**
 *  Mouse in a Maze Program:<br>
 *
 *    A Cheese object represents a piece of cheese in the maze.
 *
 *  @author Amalia Scorsone
 *  @version 5 March 2022
 **/
public class Mouse extends ColorBlock
{
    /** Constructs a piece of cheese at the specified location in
     *  a grid.
     **/
    public Mouse()
    {
        super(new NamedColor(Color.LIGHT_GRAY));
    }

    // casting the maze
    /** Recasts the grid so it displays the Maze class
     *
     **/
    public Maze  maze(){
        return (Maze) grid();
    }

    // find the next location for the mouse 
    /** Finds this mouses's next location.
     *  returns the location that it is going to move to 
     **/
    public Location nextLocation(){
        // Get list of neighboring empty locations.
        ArrayList<Location> emptyNbrs = emptyNeighbors();

        // display avaible locations
        Debug.print("Possible new locations are: " + emptyNbrs.toString());
        // if there are no locations stay where you are
        //if ( emptyNbrs.size() == 0 )
            return location();
            

    }

    /** Finds empty locations adjacent to the mouse .
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
            if ( grid().isEmpty(loc) || loc.equals(maze().getFinishLoc()))
                emptyNbrs.add(loc);
               
        }

        return emptyNbrs;
    }

    /** Moves the Mouse in its environment.
     **/
    public void move(){
        Debug.print("Fish " + toString() + " attempting to move.  ");
        // set next location vairble waual to the method
        Location nextLoc = nextLocation();
        int check= 0;
        // if the next location is the cheese remove cheese and then move into that location
        if ( nextLoc.equals(maze().getFinishLoc()))
        {

            maze().remove(nextLoc);
            Location oldLoc = location();
            changeLocation(nextLoc);
            check = check++;

        }
        // if nextloc doesn't euqal the current loctian, set the current location to the old location and 
        // move to the nextloc
        if (! nextLoc.equals(location()))
        {
            Location oldLoc = location();
            changeLocation(nextLoc);
            check++;
        }
       
        Debug.print("Mouses loction.." + nextLocation() + "Mouses class..." + this.getClass().getName());

        

    }
}
