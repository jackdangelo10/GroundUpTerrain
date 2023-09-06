package WorldMapGeneration;

public class Rectangle 
{
    private int startX = 0;
    private int startY = 0;
    private int width = 0;
    private int height = 0;

    public Rectangle(int width, int height, int x, int y) 
    {
        this.width = width;
        this.height = height;
        this.startX = x;
        this.startY = y;
    }

    public int getWidth() 
    {
        return width;
    }

    public int getHeight() 
    {
        return height;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}
