package GeneticAlgorithm;
import java.awt.image.BufferedImage;

public class Candidate 
{
    private TerrainParameters parameters;
    private double fitness;
    private BufferedImage img;
    
    public Candidate(TerrainParameters param, double fit, BufferedImage pic)
    {
        parameters = param;
        fitness = fit;
        img = pic;
    }

    public TerrainParameters getParameters() {
        return parameters;
    }

    public void setParameters(TerrainParameters parameters) {
        this.parameters = parameters;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }



    public BufferedImage getImg() {
        return img;
    }



    public void setImg(BufferedImage img) {
        this.img = img;
    }

    
}
