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

class Solution {

    int [] preorder;
    int [] inorder;
    int [] hashIndex;
    final int LIMIT = 3000;
    final int OFFSET = 100;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    
        hashIndex = new int[LIMIT];

        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < preorder.length; i++) {

            hashIndex[preorder[i] + OFFSET] = i;
        }

        return constructUntil(0, inorder.length - 1);
    }

    int findRootInSubtree(int low, int high)
    {
        int rootIndex = low;

        for (int i = low + 1; i <=high; i++) {

            if (hashIndex[inorder[i] + OFFSET] < hashIndex[inorder[rootIndex] + OFFSET]) {

                rootIndex = i;
            }
        }

        return rootIndex;
    }

    TreeNode constructUntil(int low, int high)
    {
        if (low > high)
            return null;
        if (low == high) {

            return new TreeNode(inorder[low], null, null);
        }

        int rootIndex = findRootInSubtree(low, high);

        TreeNode root = new TreeNode(inorder[rootIndex], null, null);
        root.left = constructUntil(low, rootIndex - 1);
        root.right = constructUntil(rootIndex + 1, high);

        return root;
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
