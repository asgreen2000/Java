import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TreeNodeInfo
{
    TreeNode node;
    int level;

    TreeNodeInfo(TreeNode node, int level) {

        this.node = node;
        this.level = level;
    }
}



public class Solution {

    public int findBottomLeftValue(TreeNode root) {
        
        if (root == null)
            return -1;

        Queue<TreeNodeInfo> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        queue.add(new TreeNodeInfo(root, 0));
        
        while (!queue.isEmpty())
        {
            TreeNodeInfo nodeInfo = queue.remove();
            
            if (list.size() == nodeInfo.level)
            {
                list.add(new ArrayList<>());
            }

            list.get(nodeInfo.level).add(nodeInfo.node.val);

            if (nodeInfo.node.left != null)
                queue.add(new TreeNodeInfo(nodeInfo.node.left, nodeInfo.level + 1));
            if (nodeInfo.node.right != null)
                queue.add(new TreeNodeInfo(nodeInfo.node.right, nodeInfo.level + 1));   
        }


        return list.get(list.size() - 1).get(0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
