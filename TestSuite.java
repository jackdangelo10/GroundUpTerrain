import java.awt.image.BufferedImage;
import ContinentGeneration.Continent;
import ContinentGeneration.ContinentGenerator;
import Drawing.ContinentDrawer;
import Drawing.TreeStructureDrawer;
import Files.WriteToFile;
import Helper.Coordinates;
import TreeStructureGeneration.TreeGenerator;
import TreeStructureGeneration.TreeNode;
import TreeStructureGeneration.TreeTerminalVisualizer;

public class TestSuite 
{
    public static void main(String[] args) 
    {
        int height = 71;
        int width = 121;
        int centerX = (int)Math.ceil(width / 2);
        int centerY = (int)Math.ceil(height / 2);

        TreeGenerator treeGenerator = new TreeGenerator(centerX, centerY);
        TreeNode head = new TreeNode(new Coordinates(64, 36));

        treeGenerator.treeGenerator(head, 5);
        TreeTerminalVisualizer.displayTree(head, " ", false);

        ContinentGenerator continentGenerator = new ContinentGenerator();
        Continent c = continentGenerator.generateContinent(head, height, width);

        BufferedImage img = null;
        img = ContinentDrawer.drawContinent(c.getContinentShape(), width, height);
        img = TreeStructureDrawer.drawTreeStructure(img, head);

        WriteToFile.writeToFile(img);   
    }
}
