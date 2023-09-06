package Drawing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import ContinentGeneration.Continent;
import WorldMapGeneration.WorldMap;

public class WorldMapDrawer 
{
    public static BufferedImage drawWorldMap(WorldMap map)
    {
        BufferedImage img = new BufferedImage(map.getParameters().getWidth(), 
            map.getParameters().getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = img.createGraphics();
        graphics.setPaint(new Color(51,51,255));
        graphics.fillRect(0, 0, map.getParameters().getWidth(), 
            map.getParameters().getHeight());

        graphics.setPaint(Color.GREEN);

        for(Continent c : map.getContinents())
        {
            graphics.fill(c.getContinentShape());
        }
        
        return img;
    }
}
