package TreeStructureGeneration;

import java.util.Random;

import Helper.Coordinates;

public class TreeGenerator 
{
    private int MAX_CHILDREN = 0;
    private BranchGenerator bCalc = null;
    private boolean firstFlag = true;

    private static Random random = new Random();

    public TreeGenerator(int centerx, int centery, int maxChildren)
    {
        bCalc = new BranchGenerator(centerx, centery);
        MAX_CHILDREN = maxChildren;
    }

    public void generateTree(TreeNode head, int maxDepth)
    {
        if(maxDepth <= 0)
        {
            return;
        }

        int childrenCount = randomChildrenCount();
        for(int i = 0; i < childrenCount; i++)
        {
            Coordinates c = bCalc.calculateNewBranchCoords(head.getX(), head.getY());
            TreeNode temp = new TreeNode(new Coordinates(c.getX(), c.getY()));
            head.addChild(temp);
            generateTree(temp, maxDepth - 1);
        }
    }

    public int randomChildrenCount()
    {
        
        int childrenCount = 0;

        if(Math.random() < .5 && firstFlag == false)
        {
            return -1;
        }
        else
        {
            childrenCount = random.nextInt(MAX_CHILDREN) + 1;
            firstFlag = false;
        }
        return childrenCount;
    }
}
