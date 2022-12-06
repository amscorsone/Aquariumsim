
import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Location;

/**
* sets up the intiatial objects in the maze aka the start location of the cheese and mouse and where the mouse should hopefully end up
*
* @Amalia
* @March 13 2022
*/
public class Maze extends BoundedGrid
{   
// instance variables - replace the example below with your own
        Location startingLoc;
        Location finishLoc;
        
/**
* Constructor for objects of class Maze
*/
    public Maze(int rows, int cols)
    {
    // initialise instance variables
    super(rows,cols);

    }

/**
* THis sets the location fo the mouse 
*
* @param the starting locaiton of the mouse 
* @return void
*/
    public void setStartLoc(Location startLoc)
{
 startingLoc = startLoc;
}



/**
* This is how the cheese gets set into the maze
*
* @param the end location of the mouse
* @return void
*/
    public void setFinishLoc(Location endLoc)
{
    finishLoc = endLoc;
}

/**
* get the starting location of the mouse 
* 
* @return Location that the mouse is starting
*/
    public Location getStartLoc()
{
    return startingLoc;
}

/**
* get the ending location of the mouse or the location of the cheese 
* 
* @return Location that the cheese is at - aka where the mouse shoudl end up 
*/
    public Location getFinishLoc()
{

    return finishLoc;
}
}
