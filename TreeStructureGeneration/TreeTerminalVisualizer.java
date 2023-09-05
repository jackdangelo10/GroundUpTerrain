package TreeStructureGeneration;

import java.util.List;

public class TreeTerminalVisualizer 
{
    public static void displayTree(TreeNode node, String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.getX() + " " + node.getY());
        
        List<TreeNode> children = node.getChildren();
        for (int i = 0; i < children.size() - 1; i++) {
            displayTree(children.get(i), prefix + (isTail ? "    " : "│   "), false);
        }
        if (children.size() > 0) {
            displayTree(children.get(children.size() - 1), prefix + (isTail ?"    " : "│   "), true);
        }
    }
}
