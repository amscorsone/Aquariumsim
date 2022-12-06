import java.awt.Color;

import edu.kzoo.grid.ColorBlock;
import edu.kzoo.util.NamedColor;
import java.util.ArrayList;
import java.util.Random;

import edu.kzoo.grid.Grid;
import edu.kzoo.grid.GridObject;
import edu.kzoo.grid.Location;
import edu.kzoo.util.Debug;
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
public class ShortSighted extends Mouse
{

    /** Constructs a piece of cheese at the specified location in
     *  a grid.
     **/
    public ShortSighted()
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
            if ( grid().isEmpty(loc) || loc.equals(maze().getFinishLoc()))
                emptyCNbrs.add(loc);
        }

        // Get all the neighbors of this mouse, .
        ArrayList<Location> emptymNbrs = emptyNeighbors();
        System.out.println("cheese   "+ emptyCNbrs);
        System.out.println("mouse" + emptymNbrs);
        
        // Return a randomly chosen neighboring empty location. dumb mouse code 
        Random randNumGen = RandNumGenerator.getInstance();
        int randNum = randNumGen.nextInt(emptymNbrs.size());
        Location newLocs = (Location) emptymNbrs.get(randNum);

        //if the mouse can see the cheese then move to that location, if it cannot move randomly 
        for (Location locss : emptymNbrs){
            if ( emptyCNbrs.contains(locss)){
                System.out.println("true");
                return (maze().getFinishLoc()); 
            }
            else 
                System.out.println("false");}
        return newLocs;    


    }

}
