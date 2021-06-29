import java.util.ArrayList;
import java.util.List;



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

    List<List<Integer>> iList = new ArrayList<List<Integer>> ();
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        pathUntil(root, new ArrayList<>(), 0);
        this.targetSum = targetSum;

        return iList;
    }


    public boolean pathUntil(TreeNode root, List<Integer> list, int sum) {

        if (sum >= targetSum || root == null)
            return false;
        
        list.add(root.val);

        if (root.left == null && root.right == null)
        {
            iList.add(new ArrayList<>(list));
            return true;
        }

        boolean left = pathUntil(root.left, list, sum + root.val);
        if (!left)
            pathUntil(root.right, list, sum + root.val);
        list.remove(list.size() - 1);

        return false;
    }
}


public class App {

    public static void main(String[] args) throws Exception {
        
        


    }
}
