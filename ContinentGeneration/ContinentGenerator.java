package ContinentGeneration;

import TreeStructureGeneration.TreeNode;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.util.Random;

import GeneticAlgorithm.TerrainParameters;
import PerlinNoise.PerlinNoise1D;

public class ContinentGenerator 
{
    TerrainParameters parameters = null;

    public ContinentGenerator(TerrainParameters param)
    {
        this.parameters = param;
    }


    public Continent generateContinent(TreeNode head, int height, int width)
    {
        
        int maxRadius = (int)(Math.floor(Math.sqrt(Math.pow(height, 2) 
            + Math.pow(width, 2))) / parameters.getMaxRadiusDivisor());

        Continent c = new Continent(new Area());
        generateDepthFirstIsland(head, maxRadius, c);
        return c;
    }

    private void generateDepthFirstIsland(TreeNode head, int maxRadius, Continent c)
    {
        if(head == null)
        {
            return;
        }
        else
        {
            Area islandShape =  generateIsland(head.getX(), head.getY(), maxRadius);
            c.getContinentShape().add(islandShape);
            c.addIsland(new Island(islandShape));
        }

        for(TreeNode child : head.getChildren())
        {
            generateDepthFirstIsland(child,(int)(maxRadius / 
                (parameters.getMaxRadiusDepthDivisor())), c);
        }
    }

    private Area generateIsland(int centerX, int centerY, int maxRadius)
    {
        GeneralPath island = new GeneralPath();
        Random random = new Random();
        PerlinNoise1D nse = new PerlinNoise1D(parameters.getPersistence(), 
            parameters.getOctave(), random.nextInt(1000), parameters.getFrequency(), 
                parameters.getAmplitude(), parameters.getLatticeCount());

        double theta = 0;
        double radius = 0;
        double step = 0;

        double x = 0;
        double y = 0;

        double closeX = 0;
        double closeY = 0;

        while(theta < 360)
        {
            radius = nse.perlin1D(step);
            radius *= maxRadius * 2;

            double prevX = x;
            double prevY = y;
            x = radius * Math.cos(Math.toRadians(theta));
            y = radius * Math.sin(Math.toRadians(theta));

            if(step == 0)
            {
                island.moveTo(x + centerX, y + centerY);
                closeX = x + centerX;
                closeY = y + centerY;
            }
            else
            {
                
                int xMid = (int)(prevX + x) / 2;
                int yMid = (int)(prevY + y) / 2;
                double angle = Math.atan2(xMid - centerX, xMid - centerY);
                double directionX = Math.cos(angle);
                double directionY = Math.sin(angle);

                int displacement = (int)(Math.random() *  
                    parameters.getDisplacementModifier());

                xMid += displacement*directionX;
                yMid += displacement*directionY;

                island.curveTo(prevX + centerX, prevY + centerY, 
                    xMid + centerX, yMid + centerY, x + centerX, y + centerY);
            }

            theta += parameters.getThetaStep();
            step += parameters.getPerlinStep();
        }

        int xMid = (int)(closeX + x) / 2;
        int yMid = (int)(closeY + y) / 2;
        double angle = Math.atan2(xMid - centerX, xMid - centerY);
        double directionX = Math.cos(angle);
        double directionY = Math.sin(angle);

        int displacement = (int)(Math.random() * 5);

        xMid += displacement*directionX;
        yMid += displacement*directionY;

        island.curveTo(x + centerX, y + centerY, xMid, yMid, closeX, closeY);
        island.closePath();

        return new Area(island);
    }

}