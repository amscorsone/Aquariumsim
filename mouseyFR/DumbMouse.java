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
 * This is a subclass of the Mouse class that will move randomly to any adjacent location in the maze 
 * (the "clueless mouse")
 *
 * @author Amalia Scorsone
 * @version March 5 2022
 */
public class DumbMouse extends Mouse
{
   

    /**
     * Constructor for objects of class DumbMouse
     */
    public DumbMouse()
    {
           new NamedColor(Color.WHITE);
    }

    /**
     * this next location method will find a random palce to move to pciking fomr all of the avaible empty neighbors of the mouse
     *
     * 
     * @return    the next location the mouse will move too 
     */
    public Location nextLocation()
    {
        // Get all the neighbors of this mouse.
        ArrayList<Location> emptyNbrs = emptyNeighbors();
        
        // Return a randomly chosen neighboring empty location.
        Random randNumGen = RandNumGenerator.getInstance();
        int randNum = randNumGen.nextInt(emptyNbrs.size());
        return (Location) emptyNbrs.get(randNum);     
    }
}
