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
 * will "teleport" directly to the location of the cheese (the "beam me up" mouse).
 *
 * @author Amalia Scorsone
 * @date March 8 2022 
 */
public class TeleMouse extends Mouse
{

    /** Constructs a piece of cheese at the specified location in
     *  a grid.
     **/
    public TeleMouse()
    {
        new NamedColor(Color.WHITE);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Location nextLocation()
    {
        // call the emptyNeighbors method from the mosue class and assign it to a new variable emptyNbrs
        ArrayList<Location> emptyNbrs = emptyNeighbors(); 
        
        // find where the cheese is and then move there
        System.out.println( (maze().getFinishLoc()));
        return (maze().getFinishLoc());

    }
}
