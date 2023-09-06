package WorldMapGeneration;

import ContinentGeneration.Continent;
import ContinentGeneration.ContinentGenerator;
import GeneticAlgorithm.TerrainParameters;
import Helper.Coordinates;
import TreeStructureGeneration.TreeGenerator;
import TreeStructureGeneration.TreeNode;

public class WorldMapGenerator 
{
    public static WorldMap generateWorldMap(TerrainParameters param)
    {
        WorldMap map = new WorldMap(param);

        for(Rectangle r : param.getRegions())
        {
            int centerX = (r.getWidth() + r.getStartX()) / 2;
            int centerY = (r.getHeight() + r.getStartY()) / 2;

            TreeGenerator treeGenerator = new TreeGenerator(centerX, centerY, 
                param.getMaxChildren());
            TreeNode head = new TreeNode(new Coordinates(centerX, centerY));

            treeGenerator.generateTree(head, param.getTreeDepth());

            ContinentGenerator continentGenerator = new ContinentGenerator(param);
            Continent c = continentGenerator.generateContinent(head, r.getHeight(), 
                r.getWidth());
            
            map.addContinent(c);
        }

        return map;
    }
}
