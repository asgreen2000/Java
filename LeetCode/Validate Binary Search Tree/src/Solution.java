import java.util.ArrayList;
import java.util.List;

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

    List<Integer> list = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        
        inOrder(root);
        return isSorted();
    }

    boolean isSorted()
    {
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i + 1) < list.get(i))
                return false;
        }

        return true;
    }
    void inOrder(TreeNode root) {

        if (root == null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}