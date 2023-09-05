package TreeStructureGeneration;

import java.util.Vector;
import Helper.Coordinates;

public class TreeNode 
{
    private Coordinates coord = null;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(Coordinates crd)
    {
        coord = crd;
    }

    public void addChild(TreeNode chld)
    {
        children.add(chld);
    }

    public TreeNode getChild(int index)
    {
        return children.get(index);
    }

    public Coordinates getCoordinates()
    {
        return coord;
    }

    public int getX()
    {
        return coord.getX();
    }

    public int getY()
    {
        return coord.getY();
    }

    public Vector<TreeNode> getChildren()
    {
        return children;
    }
}
