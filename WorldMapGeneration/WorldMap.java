package WorldMapGeneration;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Style;

import ContinentGeneration.Continent;
import GeneticAlgorithm.TerrainParameters;

public class WorldMap 
{
    private List<Continent> continents = new ArrayList<Continent>();
    private TerrainParameters parameters = null;
    
    public WorldMap(TerrainParameters p)
    {
        this.parameters = p;
    }

    public void addContinent(Continent c)
    {
        continents.add(c);
    }

    public void print()
    {
        for(Continent c: continents)
        {
            System.out.println(c.getHead().getX() + " " + c.getHead().getY());
        }
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    public TerrainParameters getParameters() {
        return parameters;
    }

    public void setParameters(TerrainParameters parameters) {
        this.parameters = parameters;
    }

    

}
