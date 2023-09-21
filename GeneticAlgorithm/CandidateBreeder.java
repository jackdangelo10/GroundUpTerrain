package GeneticAlgorithm;

import java.awt.image.BufferedImage;

import Drawing.WorldMapDrawer;
import Files.WriteToFile;
import WorldMapGeneration.WorldMap;
import WorldMapGeneration.WorldMapGenerator;

public class CandidateBreeder 
{
    public static Candidate breed(Candidate parent1, 
        Candidate parent2)
    {
        //blend formula: (param1*ranking/10 + param2*ranking2/10) / (ranking/10 + ranking2/10)
        //average? weighted blend?
        TerrainParameters baby = new TerrainParameters(parent1.getParameters().getWidth(),
            parent1.getParameters().getHeight(), 1001);

            
        baby.frequency = blend(parent1.getParameters().frequency, parent2.getParameters().frequency);
        
        baby.amplitude = blend(parent1.getParameters().amplitude, parent2.getParameters().amplitude);
        
        baby.persistence = blend(parent1.getParameters().persistence, parent2.getParameters().persistence);

        baby.octave = (int)(blend(parent1.getParameters().octave, parent2.getParameters().octave));
        
        baby.globalSeed = (long)blend(parent1.getParameters().globalSeed, parent2.getParameters().globalSeed);

        baby.latticeCount = (int)blend(parent1.getParameters().latticeCount, parent2.getParameters().latticeCount);

        baby.maxRadiusDivisor = blend(parent1.getParameters().maxRadiusDivisor, parent2.getParameters().maxRadiusDivisor);

        baby.maxRadiusDepthDivisor = blend(parent1.getParameters().maxRadiusDepthDivisor, parent2.getParameters().maxRadiusDepthDivisor);

        baby.displacementModifier = blend(parent1.getParameters().displacementModifier, parent2.getParameters().displacementModifier);

        baby.thetaStep = blend(parent1.getParameters().thetaStep, parent2.getParameters().thetaStep);

        baby.perlinStep = blend(parent1.getParameters().perlinStep, parent2.getParameters().perlinStep);

        Mutator.mutate(baby);

        WorldMap map = WorldMapGenerator.generateWorldMap(baby);
        map.print();
        BufferedImage img = WorldMapDrawer.drawWorldMap(map);
        WriteToFile.writeToFile(img, Math.random());
        return new Candidate(baby, -1, img);
    }




    private static double blend(double param1, double param2)
    {
        return  (param1 + param2) / 2;
    } 
        
}
