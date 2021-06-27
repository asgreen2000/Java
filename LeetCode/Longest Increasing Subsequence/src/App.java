
class BinaryTree
{   
    int maxInc = -1;
    Node rootNode;

    class Node {

        int val;
        int height;
        int count;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.count = 1;
        }
    }

    int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }

    Node rotateRight(Node root)
    {
        if (root == null || root.left == null)
            return root;
        Node left = root.left;
        
        // rotate
        root.left = left.right;
        left.right = root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        left.height = Math.max(height(left.left), height(left.right)) + 1;

        return left;
    }

    Node rotateLeft(Node root)
    {
        if (root == null || root.left == null)
            return root;
        Node right = root.right;
        
        // rotate
        root.right = right.left;
        right.left = root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        right.height = Math.max(height(right.left), height(right.right)) + 1;
        
        return right;
    }

    int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }

    Node insert(Node node, int val, int current) {

        /*10,9,2,5,3,7,101,18*/
        if (node == null) {
            return (new Node(val));
        }
        if (val < node.val)
            node.left = insert(node.left, val, 1);
        else if (val > node.val)
            node.right = insert(node.right, val, current + 1);
        else // Duplicate vals not allowed
            return node;
 
        
        node.height = 1 + Math.max(height(node.left),
                              height(node.right));
 
        int balance = getBalance(node);
 
        if (balance > 1 && val < node.left.val)
            return rotateRight(node);
 
        if (balance < -1 && val > node.right.val)
            return rotateLeft(node);
 
        if (balance > 1 && val > node.left.val) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
 
        if (balance < -1 && val < node.right.val) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }


}





public class App {

    static public int lengthOfLIS(int[] nums) {
        
        BinaryTree binaryTree = new BinaryTree();

        for (int i = 0; i < nums.length; i++) {

            binaryTree.rootNode = binaryTree.insert(binaryTree.rootNode, nums[i], 1);
        }


        return binaryTree.maxInc;
    }

    public static void main(String[] args) throws Exception {
        

        lengthOfLIS(new int[] {10,9,2,5,3,7,101,18});
    }
}
