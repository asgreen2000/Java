import java.util.List;

class NodeInfo {

    TreeNode node;
    int level;

    NodeInfo(TreeNode node, int level) {

        this.node = node;
        this.level = level;
    }
}


public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        if (root == null)
            return new ArrayList<>(); ;

        Queue<NodeInfo> queue = new LinkedList<>();

        queue.add(new NodeInfo(root, 0));

        NodeInfo prevNodeInfo = new NodeInfo(new TreeNode(-1), -1);

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) /*use BFS for searching*/
        {
            NodeInfo nodeInfo = queue.remove();

            if (prevNodeInfo.level != nodeInfo.level) // connect 
            {
                list.add(prevNodeInfo.node.val);
            }
            
            if (nodeInfo.node.left != null)
            {   
                queue.add(new NodeInfo(nodeInfo.node.left, nodeInfo.level + 1));
            }

            if (nodeInfo.node.right != null)
            {   
                queue.add(new NodeInfo(nodeInfo.node.right, nodeInfo.level + 1));
            }
            prevNodeInfo = nodeInfo;
        }

        list.add(prevNodeInfo.node.val);
        
        list.remove(0);
        return list;
    }

   
}