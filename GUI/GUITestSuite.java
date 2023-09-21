package GUI;

import GeneticAlgorithm.PopulationContainer;
import java.util.concurrent.TimeUnit;

public class GUITestSuite 
{
    public static void main(String[] args) 
    {
        PopulationContainer p = new PopulationContainer();
        p.generatePopulation(10, 1001);
    
        ImageRankingGUI g = new ImageRankingGUI(p.getCandidates());
    }
}
