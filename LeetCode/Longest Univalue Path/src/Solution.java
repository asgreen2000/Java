import java.util.LinkedList;
import java.util.Queue;

import jdk.nashorn.api.tree.Tree;

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

    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        
        dfs(root);
        return max;
    }

    int dfs(TreeNode root) {

        if (root == null)
            return 0;
        int left = dfs(root.left) + 1;
        int right = dfs(root.right) + 1;
        int value = 1;
        int result = 0;

        if (root.left != null && root.left.val == root.val)
        {
            value += left;
            result = left > result ? left : result;
        }
        if (root.right != null && root.right.val == root.val)
        {
            value += right;
            result = right > result ? right : result;
        }

        max = value > max ? value : max;

        
        return result;
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        Solution solution = new Solution();
        solution.longestUnivaluePath(root);
    }

}