
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
class Solution {
    
    int max = -100000;
    public int maxPathSum(TreeNode root) {
        
        this.max = Math.max(pathUntil(root), this.max);
        return this.max;
    }

    public int pathUntil(TreeNode root) {

        if (root == null)
            return 0;

        int left = pathUntil(root.left);
        int right = pathUntil(root.right);
        
        /* avoiding comparing negative value with value from pathUntil(null)*/
        int left_ = root.left == null ? -10000 : left;
        int right_ = root.right == null ? -10000 : right;

        /*Don't add these value if they are negative*/
        left = left > 0 ? left : 0;
        right = right > 0 ? right : 0;

        int max = Math.max(left_, Math.max(right_, left + right + root.val));
    
        this.max = max > this.max ? max: this.max;

        return root.val + (left > right ? left: right);
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
