package TreeStructureGeneration;

import Helper.Coordinates;
import Helper.NormalRandom;

public class BranchGenerator 
{
    private int centerX = 0;
    private int centerY = 0;
    private int width = 0;
    private int height = 0;
    private double longestRay = 0;

    public BranchGenerator(int centerx, int centery)
    {
        centerX = centerx;
        centerY = centery;

        width = centerX * 2 - 1;
        height = centerY * 2 - 1;

        longestRay = Math.floor(Math.sqrt(Math.pow(width, 2) + 
            Math.pow(height, 2)));
    }

    public Coordinates calculateNewBranchCoords(int x, int y)
    {
        if(x > width || x < 0 || y < 0 || y > height)
        {
            return new Coordinates(-1, -1);
        }
        double angle = calculateWeightedRandomAngle(x, y);
        double maxRadius = calculateMaximumRadius(x, y, angle);

        double radius = Math.random() * maxRadius;
        double directionX = Math.cos(angle);
        double directionY = Math.sin(angle);


        double branchX = x + radius * directionX;
        double branchY = y + radius * directionY;

        return new Coordinates((int)Math.floor(branchX), (int)Math.floor(branchY));

    }

    private double calculateWeightedRandomAngle(int x, int y)
    {
        double angle = Math.atan2(x - centerX, y - centerY);
        NormalRandom random = new NormalRandom(140, 360);
        angle = (angle + random.randomNum(0, 720) % 360);
        return angle;
    }

    private int calculateMaximumRadius(int x, int y, double angle)
    {
        int mapXMax = width;
        int mapYMax = height;

        double directionX = Math.cos(angle);
        double directionY = Math.sin(angle);

        double radiusMin = 0;
        double radiusMax = longestRay / 3;

        double control = .01;

        while(radiusMax - radiusMin > control)
        {
            double radiusMid = (radiusMin + radiusMax) / 2;
            double pointX = x + radiusMid * directionX;
            double pointY = y + radiusMid * directionY;

            if(1 <= pointX && pointX <= mapXMax - 1 
                && 1 <= pointY && pointY <= mapYMax)
            {
                radiusMin = radiusMid;
            }
            else
            {
                radiusMax = radiusMid;
            }
        }

        return (int)Math.floor(radiusMin);
    }
}
