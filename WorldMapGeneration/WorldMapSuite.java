package WorldMapGeneration;

import Drawing.TreeStructureDrawer;
import Drawing.WorldMapDrawer;
import Files.WriteToFile;
import GeneticAlgorithm.TerrainParameters;
import java.awt.image.BufferedImage;

import ContinentGeneration.Continent;

public class WorldMapSuite 
{
    public static void main(String[] args) 
    {
        TerrainParameters param = new TerrainParameters(.5, 
            12, .10, 7, 10001, 
            64, 1, 1.2, 
            2, 3, 3, 2, 
            15, .9, 121, 71);
        WorldMap map = WorldMapGenerator.generateWorldMap(param);
        BufferedImage img = WorldMapDrawer.drawWorldMap(map);
        for(Continent c : map.getContinents())
        {
            TreeStructureDrawer.drawTreeStructure(img, c.getHead());
        }
        



        WriteToFile.writeToFile(img, 1);

    }
}
