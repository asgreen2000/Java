import java.util.LinkedList;
import java.util.Queue;

class Node {
    protected int val;
    protected Node left;
    protected Node right;
    protected Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class NodeInfo {

    Node node;
    int level;

    NodeInfo(Node node, int level) {

        this.node = node;
        this.level = level;
    }
}


public class Solution {
    public Node connect(Node root) {
        
        if (root == null)
            return root;

        Queue<NodeInfo> queue = new LinkedList<>();

        queue.add(new NodeInfo(root, 0));

        NodeInfo prevNodeInfo = new NodeInfo(new Node(-1), -1);

        while (!queue.isEmpty()) /*use BFS for searching*/
        {
            NodeInfo nodeInfo = queue.remove();

            if (prevNodeInfo.level == nodeInfo.level) // connect 
            {
                prevNodeInfo.node.next = nodeInfo.node;
            }
            else {
                prevNodeInfo.node.next = null;
            }

            if (nodeInfo.node.left == null)
            {   
                queue.add(new NodeInfo(nodeInfo.node.left, nodeInfo.level + 1));
            }

            if (nodeInfo.node.right == null)
            {   
                queue.add(new NodeInfo(nodeInfo.node.right, nodeInfo.level + 1));
            }
            prevNodeInfo = nodeInfo;
        }

        prevNodeInfo.node.next = null;

        return root;
    }

    public static void main(String[] args) {
        
    }
}