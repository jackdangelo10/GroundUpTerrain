package Helper;

import java.util.Random;

public class NormalRandom 
{
    private double standardDeviation = 1;
    private double mean = 0;

    public NormalRandom(double dev, double mn)
    {
        standardDeviation = dev;
        mean = mn;
    }

    /**
     * return a random value in normal distribution
     * @param lowerBound values lower than this are remapped to it 
     * @param upperBound values higher than this are remapped to it
     * @return (adjusted) random value
     */
    public int randomNum(double lowerBound, double upperBound)
    {
        Random rand = new Random();
        double num = rand.nextGaussian() * standardDeviation + mean;
        if(num < lowerBound)
        {
            num = lowerBound;
        }
        else if(num > upperBound)
        {
            num = upperBound;
        }

        return (int)num;

    }
}
