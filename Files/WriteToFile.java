package Files;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class WriteToFile 
{

    public static void writeToFile(BufferedImage img, int count)
    {
        File f = null;
        try
        {
            //change filepath to whatever
            f = new File("C:/Users/jackd/Desktop/TerrainGen/GroundUpTerrain/Images/Image" + count + ".png/");
            ImageIO.write(img, "png", f);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}