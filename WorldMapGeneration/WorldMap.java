package WorldMapGeneration;

import java.awt.image.BufferedImage;

public class WorldMap 
{
    private int height = 0;
    private int width = 0;
    private BufferedImage img;

    public WorldMap(BufferedImage image)
    {
        img = image;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

}
