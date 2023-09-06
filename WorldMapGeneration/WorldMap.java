package WorldMapGeneration;

import java.util.ArrayList;
import java.util.List;

import ContinentGeneration.Continent;

public class WorldMap 
{
    private List<Continent> continents = new ArrayList<Continent>();

    public void addContinent(Continent c)
    {
        continents.add(c);
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    

}
