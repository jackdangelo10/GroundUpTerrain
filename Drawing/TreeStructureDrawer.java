package Drawing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import TreeStructureGeneration.TreeNode;

public class TreeStructureDrawer 
{
    public static BufferedImage drawTreeStructure(BufferedImage img, TreeNode head)
    {
        Graphics2D graphics = img.createGraphics();
        graphics.setPaint(Color.WHITE);
        drawDepthFirstBranches(head, graphics);
        return img;
    }

    private static void drawDepthFirstBranches(TreeNode head, Graphics2D graphics)
    {
        if(head == null)
        {
            return;
        }
        else
        {
            for(TreeNode child : head.getChildren())
            {
                graphics.drawLine(head.getX(), head.getY(), child.getX(), child.getY());
            }
        }
        for(TreeNode child : head.getChildren())
        {
            drawDepthFirstBranches(child, graphics);
        }
    }
}
