import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
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

class Pair {

    TreeNode node;
    int level;

    Pair(TreeNode node, int level) {

        this.node = node;
        this.level = level;
    }
}

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        if (root == null)
            return list;
        
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair pair = q.poll();
            int level = pair.level;
            int val = pair.node.val;
            TreeNode node = pair.node;
            if (list.size() <= level)
                list.add(new ArrayList<>());
            if (level % 2 == 0)
                addRightSide(val, level, list);
            else
                addLeftSide(val, level, list);
            
            if (node.left != null)
                q.add(new Pair(node.left, level + 1));
            if (node.right != null)
                q.add(new Pair(node.right, level + 1));
            return list;
        }
    }

    void addLeftSide(int val, int level, List<List<Integer>> list) {

        list.get(level).add(0, val);
    }

    void addRightSide(int val, int level, List<List<Integer>> list) {

        list.get(level).add(val);
    }
}