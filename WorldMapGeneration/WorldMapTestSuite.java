package WorldMapGeneration;

import java.awt.image.BufferedImage;

import Drawing.WorldMapDrawer;
import Files.WriteToFile;
import GeneticAlgorithm.TerrainParameters;

public class WorldMapTestSuite 
{
    public static void main(String[] args) 
    {
        WorldMap map = WorldMapGenerator.generateWorldMap(new TerrainParameters(223, 101));
        BufferedImage img = WorldMapDrawer.drawWorldMap(map);
        //WriteToFile.writeToFile(img);
    }
}
