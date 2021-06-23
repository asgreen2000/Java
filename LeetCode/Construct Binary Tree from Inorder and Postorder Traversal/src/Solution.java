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
 
class TreeTool {

    int [] inorder;
    int [] postorder;
    int [] hashIndex;
    final int OFFSET = 10000;
    final int LIMIT = 30000;
    TreeTool(int [] inorder, int [] postorder)
    {
        this.inorder = inorder;
        this.postorder = postorder;
        this.hashIndex = new int[LIMIT];
        for (int i = 0; i < postorder.length; i++) {

            hashIndex[postorder[i] + OFFSET] = i;
        }
    }
    TreeNode buildTree(int left, int right) {

        if (left > right)
            return null;

        int rootIndex = findRoot(left, right);
        TreeNode root = new TreeNode(inorder[rootIndex]);
        root.left = buildTree(left, rootIndex - 1);
        root.right = buildTree(rootIndex + 1, right);

        return root;
    }

    int findRoot(int left, int right) {

        int rootIndex = left;
        
        for (int i = left + 1; i <= right; i++) {

            if (hashIndex[inorder[i] + OFFSET] > hashIndex[inorder[rootIndex] + OFFSET]) {
                rootIndex = i;
            }
        }
        return rootIndex;
    }
}


public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        TreeTool tool = new TreeTool(inorder, postorder);

        return tool.buildTree(0, inorder.length - 1);
    }
    public static void main(String[] args) {
        
    }
}