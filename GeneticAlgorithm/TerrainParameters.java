package GeneticAlgorithm;

public class TerrainParameters 
{
    //MAIN PARAMETERS***************************************
    //Perlin
    double frequency = 0;
    double amplitude = 0;
    double persistence = 0;
    int octave = 0;
    long globalSeed = 0;
    int latticeCount = 0;
    
    //ContinentGeneration
    double maxRadiusDivisor = 0;
    double maxRadiusDepthDivisor = 0;
    double displacementModifier = 0;

    //IslandGeneration
    double thetaStep = 0;
    double perlinStep = 0;
    
    //Image
    int width = 0;
    int height = 0;

    public TerrainParameters() {}

    public void generateParameters()
    {
        frequency = Math.random();
        amplitude = Math.random()*6 + 1;
        persistence = Math.random();
        octave = (int)(Math.random() * 10) + 1;
        globalSeed = (long)Math.random()*1000;
        latticeCount = (int)(Math.random()*512 + 256);
        maxRadiusDivisor = (Math.random()*8 + 1);
        maxRadiusDepthDivisor = Math.random()*3 + .9;
        displacementModifier = Math.random()*6 - 1;
        thetaStep = Math.random() * 45;
        perlinStep = Math.random() * 3;
    }

    public TerrainParameters(double frq, double amp, double p, int oct, long seed, 
        int latticeC, double mRD, double mRDD, double dM, double tS, double pS, 
        int w, int h)
    {
        frequency = frq;
        amplitude = amp;
        persistence = p;
        octave = oct;
        globalSeed = seed;
        latticeCount = latticeC;
        maxRadiusDivisor = mRD;
        maxRadiusDepthDivisor = mRDD;
        displacementModifier = dM;
        thetaStep = tS;
        perlinStep = pS;
        width = w;
        height = h;
    }
}
