package PerlinNoise;
import java.util.Random;

/**
 * Used to generate a 1D perlin noise function to be used for 
 * smooth and natural-looking coastlines
 */
public class PerlinNoise1D 
{
    //PARAMETERS

    //Frequency - represents the interval along the domain at which
    //lattice points are generated
    //higher values result in more rapid changes, lower in slower changes
    double frequency = 0;

    //Amplitude - represents the range of outputs of the noise functio
    //range = [0, amplitude]
    double amplitude = 0;

    //Persistence - affects the amplitude of successive octaves of Perlin noise
    //smaller produce smoother noise, larger produce more choppy
    double persistence = 0;

    //Octaves - how many layers of Perln noise will be combined at various frequencies
    //and amplitudes
    int octave = 0;

    //Seed - the random value that determines behavior
    //the same seed will produce consistent outputs
    long globalSeed = 0;

    int latticeCount = 0;

    public PerlinNoise1D(double p, int oct, long sd, double f, double amp, int latCnt)
    {
        persistence = p;
        octave = oct;
        globalSeed = sd;
        frequency = f;
        amplitude = amp;
        latticeCount = latCnt;
    }

    private double[] generateGradients(int latticeCount)
    {
        Random random = new Random(globalSeed);
        double [] gradients = new double[latticeCount];


        for(int i = 0; i < latticeCount; i++)
        {
            gradients[i] = random.nextDouble() * 2 - 1;
        }

        return gradients;
    }

    /**
     * calculates contributions from nearest lattice points
     * @param x the value in the domain
     */
    private double noise1D(double x, double[] gradients)
    {
        int latticePoint = (int) Math.floor(x);
        double t = x - latticePoint;    

        int index0 = latticePoint % gradients.length;
        int index1 = (index0 + 1) % gradients.length;

        double gradient0 = gradients[index0];
        double gradient1 = gradients[index1];

        return cerp(gradient0, gradient1, (fade(t)));
    }

    public double perlin1D(double t)
	{
		double sum = 0;
        double frq = frequency;
        double amp = amplitude;
        double maxAmplitude = 0;
        
		for(int i = 0; i < octave; i++)
		{
			sum += noise1D(t * frq, generateGradients(latticeCount)) * amp;
            maxAmplitude += amplitude;
            frq *= 2;
            amp *= persistence;
		}
		return sum / maxAmplitude;
	}

    private static double fade(double t) 
    {
        return t * t * t * (t * (t * 6 - 15) + 10);
    }

    private double cerp(double yi, double yi1, double alpha)
	{
		return (1 - gcos(alpha)) * yi + gcos(alpha)*yi1;
	}

    private double gcos(double alpha)
	{
		return (1 - Math.cos(Math.PI * alpha)) / 2;
	}

}
