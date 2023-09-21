package GeneticAlgorithm;

import java.util.Random;

public class Mutator 
{
    private final static double MUTATION_RATE = .1;
    private static Random random = new Random();

    public static void mutate(TerrainParameters parameters)
    {
        if(Math.random() < .05)
        {
            if(random.nextDouble() < MUTATION_RATE)
            {
                parameters.frequency += random.nextDouble(.02) - .01; //-.01 to .01
                parameters.amplitude += random.nextDouble(.2) - .1; //-.1 to .1
                parameters.persistence += random.nextDouble(.01) - .005; //-.005 to 0.005
                parameters.octave += random.nextDouble(2) - 1; //-1 to 1
                parameters.latticeCount += random.nextDouble(20) - 10;//-10 to 10
                parameters.maxRadiusDivisor += random.nextDouble(.01) - .005;//-.005 to .005
                parameters.maxRadiusDepthDivisor += random.nextDouble(.004) - .002;//-.002 to .002 
                parameters.displacementModifier += random.nextDouble(.1) - .05;//-.05 to .05
                parameters.thetaStep += random.nextDouble(.4) -.2;//-.2 to .2
                parameters.perlinStep += random.nextDouble(.004) - .002;//-.002 to .002
                parameters.treeDepth += random.nextInt(2) - 1;
                parameters.maxChildren += random.nextInt(2) - 1;
                parameters.continentCount += random.nextInt(2) - 1;

                checkBounds(parameters);
            }
        }
        

    }


    private static void checkBounds(TerrainParameters parameters)
    {
        Random random = new Random();
        while(parameters.treeDepth < 1)
        {
            parameters.treeDepth += 1;
        }
        while(parameters.treeDepth > 5)
        {
            parameters.treeDepth -= 1;
        }

        
        while(parameters.maxChildren < 3)
        {
            parameters.maxChildren += 1;
        }
        while(parameters.maxChildren > 5)
        {
            parameters.maxChildren -= 1;
        }

        while(parameters.continentCount < 1)
        {
            parameters.continentCount += 1;
        }
        while(parameters.continentCount > 4)
        {
            parameters.continentCount -= 1;
        }

        while(parameters.frequency <= 0)
        {
            parameters.frequency += (random.nextDouble() * .02);
        }
        while(parameters.persistence < 0)
        {
            parameters.persistence += (random.nextDouble() * .02);
        }
        while(parameters.persistence > 1)
        {
            parameters.persistence -= (random.nextDouble() * .02);
        }
        while(parameters.octave > 10)
        {
            parameters.octave -= (random.nextInt(2));
        }
        while(parameters.octave < 1)
        {
            parameters.octave += (random.nextInt(2));
        }
        while(parameters.thetaStep > 45)
        {
            parameters.thetaStep -= (random.nextDouble()*4);
        }
        while(parameters.thetaStep < 1)
        {
            parameters.thetaStep += (random.nextDouble()*4);
        }

    }
}
