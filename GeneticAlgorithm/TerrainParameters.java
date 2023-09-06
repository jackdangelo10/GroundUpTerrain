package GeneticAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import WorldMapGeneration.Rectangle;

public class TerrainParameters 
{
    //MAIN PARAMETERS***************************************

    //RANDOM
    Random random = new Random();

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
    
    //TreeGeneration
    int treeDepth = 0;
    int maxChildren = 0;

    //ContinentRegionGeneration
    int continentCount = 0;
    List<Rectangle> regions = null;
        //region information



    //IslandGeneration
    double thetaStep = 0;
    double perlinStep = 0;
    
    //Image
    public int width = 0;
    public int height = 0;

    public TerrainParameters(int w, int h) 
    {
        width = w;
        height = h;
        generateParameters();
    }

    private void generateParameters()
    {
        this.frequency = Math.random();
        this.amplitude = Math.random()*6 + 1;
        this.persistence = Math.random();
        this.octave = (int)(Math.random() * 10) + 1;
        this.globalSeed = (long)(Math.random()*1000);
        this.latticeCount = (int)(Math.random()*512 + 256);
        this.maxRadiusDivisor = (Math.random()*8 + 1);
        this.maxRadiusDepthDivisor = Math.random()*3 + .9;
        this.displacementModifier = Math.random()*6 - 1;
        this.thetaStep = Math.random() * 45;
        this.perlinStep = Math.random() * 3;
        this.treeDepth = random.nextInt(3) + 2;
        this.maxChildren = random.nextInt(5);

        this.continentCount = (int)(random.nextInt(3)) + 2;
        this.regions = generateRegions(continentCount);

        for(int i = 0; i < regions.size(); i++)
        {
            if(regions.get(i).getWidth() == 0 || regions.get(i).getHeight() == 0)
            {
                regions.remove(i);
            }
        }

        for(int i = 0; i < regions.size(); i++)
        {
            Rectangle subrectangle = regions.get(i);
            System.out.println("Subrectangle " + (i + 1) + ":");
            System.out.println("x: " + subrectangle.getStartX());
            System.out.println("y: " + subrectangle.getStartY());
            System.out.println("Width: " + subrectangle.getWidth());
            System.out.println("Height: " + subrectangle.getHeight());
            System.out.println();
        }
    }

    private List<Rectangle> generateRegions(int continentCount)
    {
        List<Double> proportions = generateProportions(continentCount);
        System.out.println(continentCount);
        System.out.println(proportions);

        return divideRegions(new Rectangle(width, height, 0, 0), proportions); 
    }

    private List<Rectangle> divideRegions(Rectangle mapRect, List<Double> proportions)
    {

        List<Rectangle> regions = new ArrayList<Rectangle>();
        for(Double proportion : proportions)
        {
            Rectangle region = createRegion(mapRect, proportion);
            regions.add(region);
        }

        return regions;
    }


    private Rectangle createRegion(Rectangle mapRect, double proportion)
    {
       



        return new Rectangle(subWidth, subHeight, mapRect.getStartX(), mapRect.getStartY());
    }


    private List<Double> generateProportions(int continentCount)
    {
        Random random = new Random();
        List<Double> proportions = new ArrayList<Double>();
        double remainder = 1.0;

        for(int i = 0; i < continentCount; i++)
        {
            double proportion = remainder * random.nextDouble();
            proportions.add(proportion);
            remainder -= proportion;
        }

        proportions.add(remainder);
        return proportions;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public double getPersistence() {
        return persistence;
    }

    public void setPersistence(double persistence) {
        this.persistence = persistence;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(int octave) {
        this.octave = octave;
    }

    public long getGlobalSeed() {
        return globalSeed;
    }

    public void setGlobalSeed(long globalSeed) {
        this.globalSeed = globalSeed;
    }

    public int getLatticeCount() {
        return latticeCount;
    }

    public void setLatticeCount(int latticeCount) {
        this.latticeCount = latticeCount;
    }

    public double getMaxRadiusDivisor() {
        return maxRadiusDivisor;
    }

    public void setMaxRadiusDivisor(double maxRadiusDivisor) {
        this.maxRadiusDivisor = maxRadiusDivisor;
    }

    public double getMaxRadiusDepthDivisor() {
        return maxRadiusDepthDivisor;
    }

    public void setMaxRadiusDepthDivisor(double maxRadiusDepthDivisor) {
        this.maxRadiusDepthDivisor = maxRadiusDepthDivisor;
    }

    public double getDisplacementModifier() {
        return displacementModifier;
    }

    public void setDisplacementModifier(double displacementModifier) {
        this.displacementModifier = displacementModifier;
    }

    public int getContinentCount() {
        return continentCount;
    }

    public void setContinentCount(int continentCount) {
        this.continentCount = continentCount;
    }

    public List<Rectangle> getRegions() {
        return regions;
    }

    public void setRegions(List<Rectangle> regions) {
        this.regions = regions;
    }

    public double getThetaStep() {
        return thetaStep;
    }

    public void setThetaStep(double thetaStep) {
        this.thetaStep = thetaStep;
    }

    public double getPerlinStep() {
        return perlinStep;
    }

    public void setPerlinStep(double perlinStep) {
        this.perlinStep = perlinStep;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTreeDepth() {
        return treeDepth;
    }

    public void setTreeDepth(int treeDepth) {
        this.treeDepth = treeDepth;
    }

    public int getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(int maxChildren) {
        this.maxChildren = maxChildren;
    }

    
    
}
