package Files;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class WriteToFile 
{

    public static void writeToFile(BufferedImage img)
    {
        File f = null;
        try
        {
            //change filepath to whatever
            f = new File("C:/Users/jackd/Desktop/GroundUpTerrain/Images/Image.png/");
            ImageIO.write(img, "png", f);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}