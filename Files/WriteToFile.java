package Files;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.imageio.ImageIO;

import GeneticAlgorithm.TerrainParameters;

public class WriteToFile 
{

    public static void writeToFile(BufferedImage img, double count)
    {
        File f = null;
        try
        {
            //change filepath to whatever
            f = new File("C:/Users/jackd/Desktop/playground/GroundUpTerrain/Images/Image" + count + ".png/");
            ImageIO.write(img, "png", f);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void checkoutParameters(TerrainParameters param)
    {
        String filePath = "data.txt";
        try
        {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bWriter = new BufferedWriter(writer);
            bWriter.write(param.getFrequency() + " " + param.getAmplitude() + " " +
                param.getPersistence() + " " + param.getOctave() + " " + param.getLatticeCount() +
                " " + param.getMaxRadiusDivisor() + " " + param.getMaxRadiusDepthDivisor() + " " + 
                param.getDisplacementModifier() + " " + param.getThetaStep() + " " + 
                param.getPerlinStep() + " " + param.getTreeDepth() + " " + param.getMaxChildren()
                + " " + param.getContinentCount());

            bWriter.close();
            
        }
        catch(Exception e)
        {
            System.out.println("could not find data.txt");
        }

        
        
    }
}