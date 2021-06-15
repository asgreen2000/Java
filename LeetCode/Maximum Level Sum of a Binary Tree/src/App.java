import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

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

public class App {

    static HashMap<Integer, Integer> levelSum = new HashMap<>();

    static public int maxLevelSum(TreeNode root) {
        

        int max = Collections.max(levelSum.values());
        for (Integer key : levelSum.keySet())
        {
            if (levelSum.getOrDefault(key, 0) == max)
                return key;
        }

        return -1;
    }

    static void dfs(TreeNode root, int level)
    {
        if (root == null)
            return;
        levelSum.put(level, levelSum.getOrDefault(level, 0) + root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
