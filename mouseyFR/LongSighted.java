import java.awt.Color;

import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.NamedColor;
import java.util.ArrayList;
import java.util.Random;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.util.Debug;
import edu.kzoo.grid.Direction;
import edu.kzoo.util.RandNumGenerator;

/**
 *move randomly until you see the cheese no matter how far away
make list of all empty neighbors and if there is nothing in the way, meaning 
all of the spaces in between the cheese and mouse are empty the mouse will teleport to the
cheese, this means you start with dumb mouse code and then implemnet something to 
notice when the cheese is within the direct path and then use the teleport mouse code 
 * @author Amalia Scorsone
 * @date March 8 2022 
 */
public class LongSighted extends Mouse
{
    // instance variables - replace the example below with your own

    /** Constructs a piece of cheese at the specified location in
     *  a grid.
     **/
    public LongSighted()
    {
        new NamedColor(Color.WHITE);
    }

    public Location nextLocation()
    {
        // find all open location next to the cheese 
        ArrayList<Location> cheeseNbrs = grid().neighborsOf(maze().getFinishLoc());
        // Figure out which neighbors are empty and add those to a new list.
        ArrayList<Location> emptyCNbrs = new ArrayList<Location>();
        for ( Location loc : cheeseNbrs )
        {
            if ( grid().isEmpty(loc) || loc.equals(maze().getFinishLoc().col()))
                emptyCNbrs.add(loc);
        }

        // Get all the neighbors of this mouse, .
        ArrayList<Location> emptymNbrs = emptyNeighbors();

        // print out the empty spots avaible 
        System.out.println("cheese   "+ emptyCNbrs);
        System.out.println("mouse" + emptymNbrs);

        // Return a randomly chosen neighboring empty location. dumb mouse code 
        Random randNumGen = RandNumGenerator.getInstance();
        int randNum = randNumGen.nextInt(emptymNbrs.size());
        Location newLocs = (Location) emptymNbrs.get(randNum);
        
        // Look thoruhg each on of the empty mouse neighbors and check to see if the mouse is in the same col or row as the 
        //cheese and has no obstacles in the way the way. If both statements the the mouse can move closer and closer to the 
        // until it find its. 
        for (Location locss : emptymNbrs){
            //check to see if the mouse and cheese is in the same column
            if (locss.col() ==  maze().getFinishLoc().col()){

                System.out.println("true the mouse and the cheese are in the same col() ");

                //find the direction that the mouse has to go to move form its curretn location to the location of the cheese
                Direction dir = (Direction) maze().getDirection(location(),maze().getFinishLoc());

                // using the direction which spot must the mouse move to to get closer to the cheese
                Location locC = (Location) maze().getNeighbor(location(),dir);

                // once the next spot is found check to make that that spot is empty and the mouse can move into it
                if (maze().isEmpty(locC)){
                    System.out.println(" there's nothing in the way so the location closer to the cheese is:.. "+ locC);

                    return (locC);
                }
                else {
                    // if there something in the way.. 
                    System.out.println("the cooridate: "+ locC + "is not avaible");
                    return newLocs;
                }
            }
            //check to see if the mouse and cheese are in the same row
            else if (locss.row() ==  maze().getFinishLoc().row() ){

                System.out.println("true the mouse and the cheese are in the same row() ");
                //find the direction that the mouse has to go to move form its curretn location to the location of the cheese
                Direction dir = (Direction) maze().getDirection(location(),maze().getFinishLoc());

                // using the direction which spot must the mouse move to to get closer to the cheese
                Location locC = (Location) maze().getNeighbor(location(),dir);

                // once the next spot is found check to make that that spot is empty and the mouse can move into it
                if (maze().isEmpty(locC)){
                    System.out.println(" there's nothing in the way so the location closer to the cheese is:.. "+ locC);
                    // move to the new location 
                    return (locC);
                }
                else {
                    // if there is something in the way...
                    System.out.println("the cooridate: "+ locC + "is not avaible");
                    return newLocs;}
            }
            else {
                return newLocs;

            }

        }

        return newLocs;
    } 
}