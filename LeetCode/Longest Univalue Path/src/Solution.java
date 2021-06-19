import java.util.LinkedList;
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




public class Solution {

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        
        
    }

    int dfs(TreeNode root) {

        if (root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int value = 1;

        if (root.left != null && root.left.val == root.val)
        {
            value += left;
        }
        if (root.right != null && root.right.val == root.val)
        {
            value += right;
        }
        max = value > max ? value : max;

        return left > right ? left : right;
    }

}