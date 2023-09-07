package GUI;

import GeneticAlgorithm.PopulationContainer;

public class GUITestSuite 
{
    public static void main(String[] args) 
    {
        PopulationContainer p = new PopulationContainer();
        p.generatePopulation(10);
        GUI g = new GUI(p.getCandidates());
    }
}
