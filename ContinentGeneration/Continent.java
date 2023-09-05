package ContinentGeneration;

import java.awt.geom.Area;
import java.util.Vector;

public class Continent 
{
    Area continentShape = null;
    Vector<Island> islands = new Vector<Island>();

    public Continent(Area c)
    {
        continentShape = c;
    }

    public void addIsland(Island i)
    {
        islands.add(i);
    }

    public Area getContinentShape()
    {
        return continentShape;
    }
}
