package GeneticAlgorithm;

import java.util.Random;

public class Mutator 
{
    private final static double MUTATION_RATE = .1;

    public static void mutate(TerrainParameters parameters)
    {
        Random random = new Random();
        if(random.nextDouble() < MUTATION_RATE)
        {
            parameters.frequency += (Math.random()*8 - 4);
            parameters.amplitude += (random.nextDouble() * 1 - .5);
            parameters.persistence += (random.nextDouble() * .02 - .01);
            parameters.octave += (random.nextInt(2) - 1);
            parameters.latticeCount += (random.nextInt(6) - 3);
            parameters.maxRadiusDivisor += (random.nextDouble() - .25);
            parameters.maxRadiusDepthDivisor += (random.nextDouble()*.1 - .25);
            parameters.displacementModifier += (random.nextDouble() - .5);
            parameters.thetaStep = (random.nextDouble()*3 - 1.5);
            parameters.perlinStep = (random.nextDouble()*.4 - .2);
            parameters.treeDepth = random.nextInt(2) - 1;
            parameters.maxChildren = random.nextInt(2) - 1;
            parameters.continentCount = random.nextInt(2) - 1;

            checkBounds(parameters);
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
