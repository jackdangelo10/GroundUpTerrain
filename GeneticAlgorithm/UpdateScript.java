package GeneticAlgorithm;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Drawing.WorldMapDrawer;
import Files.WriteToFile;
import WorldMapGeneration.WorldMap;
import WorldMapGeneration.WorldMapGenerator;

public class UpdateScript 
{
    public static List<Candidate> update(List<Candidate> candidates)
    {
        candidates.sort(Comparator.comparingInt(Candidate::getFitness).reversed());

        for (int i = 0; i < 4; i++) 
        {
            candidates.remove(candidates.size() - 1);
        }

        List<Candidate> top4Candidates = candidates.subList(0, 4);

        List<Candidate> newCandidates = new ArrayList<Candidate>();
        newCandidates.add(CandidateBreeder.breed(top4Candidates.get(0), 
            top4Candidates.get(1)));
        newCandidates.add(CandidateBreeder.breed(top4Candidates.get(2), 
            top4Candidates.get(3)));

        candidates.addAll(newCandidates);

        for(int i = 0; i < 2; i++)
        {
            WorldMap map = WorldMapGenerator.generateWorldMap(new 
                TerrainParameters(candidates.get(7).getParameters().getWidth(), 
                    candidates.get(7).getParameters().getHeight()));
            BufferedImage img = WorldMapDrawer.drawWorldMap(map);
            WriteToFile.writeToFile(img, i);
            
            candidates.add(new Candidate(map.getParameters(), -1, img));
        }
        
        return candidates;
    }
}
