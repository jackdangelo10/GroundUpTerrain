package GeneticAlgorithm;

import java.util.List;

import Drawing.WorldMapDrawer;
import Files.WriteToFile;
import WorldMapGeneration.WorldMap;
import WorldMapGeneration.WorldMapGenerator;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PopulationContainer 
{
    List<Candidate> population = new ArrayList<Candidate>();

    public void generatePopulation(int size, int s)
    {
        for(int i = 0; i < size; i++)
        {
            WorldMap map = WorldMapGenerator.generateWorldMap(new 
                TerrainParameters(223, 101, s));
            BufferedImage img = WorldMapDrawer.drawWorldMap(map);
            WriteToFile.writeToFile(img, i);
            
            population.add(new Candidate(map.getParameters(), -1, img));
        }
    }

    public List<Candidate> getCandidates()
    {
        return population;
    }


}
