import edu.kzoo.grid.Direction;
import edu.kzoo.grid.display.DisplayMap;
import edu.kzoo.grid.gui.GridPkgFactory;

import mbsgui.MBSGUI;
import mbsgui.FishDisplay;
import mbsgui.LittleFishDisplay;
import mbsgui.NarrowFishDisplay;
import mbsgui.RoundFishDisplay;
import mbsgui.FishImageDisplay;
import edu.kzoo.util.Debug;

// Class MBSApp
//
// Author: Alyce Brady
//
// This class is based on the College Board's MBSGUI class,
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

/**
 *  Grid-Based Marine Biology Simulation Program:<br>
 *
 *  The <code>MBSApp</code> class provides a main method
 *  for a Marine Biology Simulation program with a graphical
 *  user interface.
 *
 *  @author Alyce Brady (based partly on the AP CS MBSGUI class)
 *  @version 25 April 2019
 **/
public class MBSApp
{

    /** Start the MBS program.
     *  The String arguments (args) are not used in this application.
     **/
    public static void main(String[] args)
    {
        Debug.turnOn();
        // Specify what types of objects we have that can be placed in the grid. 
        // This array is used to provide a choice of object types in the
        // pull-down menu when manually placing objects into the grid.
        String[] mbsObjectTypes = {"Fish" 
                                    , "simpleFish" , "whiteFish",
                                    "DarterFish", "slowFish" ,
                                    "CircleFish", "SlowerFish"
                    
                                  };
        GridPkgFactory.addGridObjClassNames(mbsObjectTypes);

        // Specify classes that know how to draw various grid objects;
        // in other words, map grid object classes (like Fish) to
        // display objects (like FishDisplay or FishImageDisplay objects).
        DisplayMap.associate("Fish", new LittleFishDisplay());
        DisplayMap.associate("simpleFish", new RoundFishDisplay()); //new subclass
         DisplayMap.associate("whiteFish", new RoundFishDisplay());
         DisplayMap.associate("DarterFish", new NarrowFishDisplay());
         DisplayMap.associate("slowFish", new RoundFishDisplay());
        DisplayMap.associate("CircleFish", new RoundFishDisplay()); //new subclass
        DisplayMap.associate("SlowerFish", new NarrowFishDisplay()); //new subclass
        
        // The display alternatives include FishDisplay, LittleFishDisplay,
        //      NarrowFishDisplay, and RoundFishDisplay.  You can also find
        //      other fish images.                                            

        // Create and show the window containing the graphical user interface.
        MBSGUI window = new MBSGUI();
    }
}

