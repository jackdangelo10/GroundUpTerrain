package ContinentGeneration;

import java.awt.geom.Area;
import java.util.Vector;

import TreeStructureGeneration.TreeNode;


public class Continent 
{
    Area continentShape = null;
    TreeNode head = null;
    Vector<Island> islands = new Vector<Island>();

    public Continent(Area c, TreeNode h)
    {
        continentShape = c;
        head = h;
    }

    public void addIsland(Island i)
    {
        islands.add(i);
    }

    public Area getContinentShape()
    {
        return continentShape;
    }

    public Vector<Island> getIslands() {
        return islands;
    }

    public void setIslands(Vector<Island> islands) {
        this.islands = islands;
    }

    public void setContinentShape(Area continentShape) {
        this.continentShape = continentShape;
    }

    public TreeNode getHead() {
        return head;
    }

    public void setHead(TreeNode head) {
        this.head = head;
    }
    

    
}
