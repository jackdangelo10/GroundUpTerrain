package PerlinNoise;

public class NoiseTesting 
{
    public static void main(String[] args) 
    {
        PerlinNoise1D noise = new PerlinNoise1D(.03, 4, 101, .05, 1, 100);
        double theta = 0;
        System.out.println(noise.perlin1D(theta));
        
        while(theta < 256)
        {
            //System.out.println("theta: " + theta);
            System.out.println(noise.perlin1D(theta));
            theta += .5;
        }
        
    }
}
