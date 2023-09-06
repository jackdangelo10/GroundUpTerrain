package WorldMapGeneration;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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
        WorldMap map = new WorldMap();

        BufferedImage img = new BufferedImage(param.getWidth(), param.getHeight(), 
        BufferedImage.TYPE_INT_ARGB);

        List<TreeNode> heads = new ArrayList<TreeNode>();

        for(Rectangle r : param.getRegions())
        {
            int centerX = (r.getWidth() + r.getStartX()) / 2;
            int centerY = (r.getHeight() + r.getStartY()) / 2;

            TreeGenerator treeGenerator = new TreeGenerator(centerX, centerY);
            TreeNode head = new TreeNode(new Coordinates(centerX, centerY));

            treeGenerator.treeGenerator(head, param.getTreeDepth());

            ContinentGenerator continentGenerator = new ContinentGenerator();
            Continent c = continentGenerator.generateContinent(head, r.getHeight(), 
                r.getWidth());
            
            
        }

        



        return map;
    }
}
