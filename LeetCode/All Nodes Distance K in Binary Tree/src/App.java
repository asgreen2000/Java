import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    List<Integer> list = new ArrayList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        getKdistanceNode(root, target, k);

        return list;
    }

    void downTree(TreeNode root, int k)
    {

        if (root == null || k < 0)
            return;

        if (k == 0) {
            list.add(root.val);
            return;
        }

        downTree(root.left, k - 1);
        downTree(root.right, k - 1);
    }  


    int getKdistanceNode(TreeNode root, TreeNode target, int k)
    {
        if (root == null)
            return - 1;
        
        if (root == target)
        {
            downTree(root, k);
            return 0;
        }

        int dl = getKdistanceNode(root.left, target, k);

        if (dl != -1)
        {
            if (dl + 1 == k)
                list.add(root.val);
            else
                downTree(root.right, k - dl - 2);
            
            return 1 + dl;
        }

        int dr = getKdistanceNode(root.right, target, k);

        if (dr != -1)
        {
            if (dr + 1 == k)
                list.add(root.val);
            else
                downTree(root.left, k - dr - 2);
            return 1 + dr;
        }

        return -1;
    }
}




public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
