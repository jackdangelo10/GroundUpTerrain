package GeneticAlgorithm;

import Drawing.WorldMapDrawer;
import WorldMapGeneration.WorldMap;

public class CandidateBreeder 
{
    public static Candidate breed(Candidate parent1, 
        Candidate parent2)
    {
        //blend formula: (param1*ranking/10 + param2*ranking2/10) / (ranking/10 + ranking2/10)
        //average? weighted blend?
        TerrainParameters baby = new TerrainParameters(parent1.getParameters().getWidth(),
            parent1.getParameters().getHeight());
        baby.frequency = blend(parent1.getParameters().frequency, parent1.getFitness(),
            parent2.getParameters().frequency, parent2.getFitness());
        
        baby.amplitude = blend(parent1.getParameters().amplitude, parent1.getFitness(),
            parent2.getParameters().amplitude, parent2.getFitness());
        
        baby.persistence = blend(parent1.getParameters().persistence, parent1.getFitness(),
            parent2.getParameters().persistence, parent2.getFitness());

        baby.octave = (int)(blend(parent1.getParameters().octave, parent1.getFitness(),
            parent2.getParameters().octave, parent2.getFitness()));
        
        baby.globalSeed = (long)blend(parent1.getParameters().globalSeed, parent1.getFitness(),
            parent2.getParameters().globalSeed, parent2.getFitness());

        baby.latticeCount = (int)blend(parent1.getParameters().latticeCount, parent1.getFitness(),
            parent2.getParameters().latticeCount, parent2.getFitness());

        baby.maxRadiusDivisor = blend(parent1.getParameters().maxRadiusDivisor, parent1.getFitness(),
            parent2.getParameters().maxRadiusDivisor, parent2.getFitness());

        baby.maxRadiusDepthDivisor = blend(parent1.getParameters().maxRadiusDepthDivisor, parent1.getFitness(),
            parent2.getParameters().maxRadiusDepthDivisor, parent2.getFitness());

        baby.displacementModifier = blend(parent1.getParameters().displacementModifier, parent1.getFitness(),
            parent2.getParameters().displacementModifier, parent2.getFitness());

        baby.thetaStep = blend(parent1.getParameters().thetaStep, parent1.getFitness(),
            parent2.getParameters().thetaStep, parent2.getFitness());

        baby.perlinStep = blend(parent1.getParameters().perlinStep, parent1.getFitness(),
            parent2.getParameters().perlinStep, parent2.getFitness());

        Mutator.mutate(baby);
        return new Candidate(baby, -1, WorldMapDrawer.drawWorldMap(new WorldMap(baby)));
    }




    private static double blend(double param1, double ranking1, double param2, double ranking2)
    {
        return ((param1 * ranking1) / 10 + (param2 * ranking2) / 10) 
            / (ranking1/10 + ranking2/10);
    } 
        
}
