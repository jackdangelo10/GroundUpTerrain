package GeneticAlgorithm;
import java.awt.image.BufferedImage;

public class Candidate 
{
    private TerrainParameters parameters;
    private int fitness;
    private BufferedImage img;
    
    public Candidate(TerrainParameters param, int fit, BufferedImage pic)
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

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }



    public BufferedImage getImg() {
        return img;
    }



    public void setImg(BufferedImage img) {
        this.img = img;
    }

    
}
