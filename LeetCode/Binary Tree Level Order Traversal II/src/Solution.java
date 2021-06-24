import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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

public class Solution {

    class Pair {
        TreeNode root;
        int level;

        Pair(TreeNode root, int level) {
            this.root = root;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if (root == null)
            return null;
        Queue<Pair> q = new LinkedList<>();
        
        List<List<Integer>> list = new ArrayList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty())
        {
            Pair pair = q.remove();

            if (list.size() == pair.level) {
                list.add(new ArrayList<>());
            }

            list.get(pair.level).add(pair.root.val);
            
            if (pair.root.left != null) {
                q.add(new Pair(pair.root.left, pair.level + 1));
            }

            if (pair.root.right != null) {
                q.add(new Pair(pair.root.right, pair.level + 1));
            }
        }


        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
