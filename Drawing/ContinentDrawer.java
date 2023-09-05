package Drawing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

public class ContinentDrawer 
{
    private static BufferedImage img = null;
    private static Graphics2D graphics = null;


    public static BufferedImage drawContinent(Area continent, int width, int height)
    {
        img = new BufferedImage(width, height, 
        BufferedImage.TYPE_INT_ARGB);

        graphics = img.createGraphics();
        graphics.setPaint(new Color(51,51,255));
        graphics.fillRect(0, 0, width, height);

        graphics.setPaint(Color.GREEN);

        graphics.fill(continent);

        return img;
    }
}
