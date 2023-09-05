package Helper;

public class Coordinates 
{
    public int x = 0;
    public int y = 0;

    public Coordinates(int xx, int yy)
    {
        x = xx;
        y = yy;
    }

    public void print()
    {
        System.out.println("x: " + x + " y: " + y);
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
