import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class BinaryTree {

Node root;
int size;
int [] count;
/*Define Node in BinaryTree*/
class Node
{
    int val;
    Node left, right;
    int childCount;
    int height;
    Node(int val) {

        this.val = val;
        left = right = null;
        childCount = 0;
        this.height = 0;
    }

    Node(int val, Node left, Node right) {

        this(val);
        this.left = left;
        this.right = right;
    }
}
/*---------------------------------*/

BinaryTree(int num) {

    this.root = null;
    this.count = new int[num];
}

Node rotateLeft(Node ptr)
{
    if (ptr == null || ptr.right == null)
        return ptr;
    Node rightChild = ptr.right;
    Node leftOfRight = rightChild.left;

    rightChild.left = ptr;
    ptr.right = leftOfRight;

    setHeight(ptr);
    setHeight(rightChild);

    setCount(ptr);
    setCount(rightChild);

    return rightChild;
}

Node rotateRight(Node ptr)
{
    if (ptr == null || ptr.left == null)
        return ptr;
    Node leftChild = ptr.left;
    Node rightOfLeft = leftChild.right;

    leftChild.right = ptr;
    ptr.left = rightOfLeft;

    setHeight(ptr);
    setHeight(leftChild);

    setCount(ptr);
    setCount(leftChild);

    return leftChild;
}


Node insertNode(Node ptr, int val, int pos)
{
    if (ptr == null)
    {
        return new Node(val);
    }

    if (val <= ptr.val)
    {
        ptr.left = insertNode(ptr.left, val, pos);
    }
    else {

        ptr.right = insertNode(ptr.right, val, pos);

        if (ptr.left != null)
            count[pos] += ptr.left.childCount + 1;
        else
            count[pos] += 1;
    }
    
    setHeight(ptr);
    setCount(ptr);

    int balance = getBalance(ptr);

    if (balance > 1 && val < ptr.left.val)
    {
        return rotateRight(ptr);
    }
    if (balance < -1 && val > ptr.right.val)
    {
        return rotateLeft(ptr);
    }
    if (balance > 1 && val > ptr.left.val)
	{
		ptr.left = rotateLeft(ptr.left);
		return rotateRight(ptr);
	}

	// Right Left Case
	if (balance < -1 && val < ptr.right.val)
	{
		ptr.right = rotateRight(ptr.right);
		return rotateLeft(ptr);
	}

    return ptr;
}

int getBalance(Node ptr)
{
    if (ptr == null)
        return 0;
    if (ptr.left == null && ptr.right == null)
        return 0;
    
    if (ptr.left == null)
        return -ptr.right.height;
    if (ptr.right == null)
        return ptr.left.height;
    return ptr.left.height - ptr.right.height;
}

void setCount(Node ptr) {

    if (ptr.left == null && ptr.right == null)
        ptr.childCount = 1;
    else if (ptr.left == null)
        ptr.childCount = ptr.right.childCount + 1;
    else if (ptr.right == null)
        ptr.childCount = ptr.left.childCount + 1;
    else 
        ptr.childCount = ptr.left.childCount + ptr.right.childCount + 1;
}

void setHeight(Node ptr) {

    if (ptr.left == null && ptr.right == null)
        ptr.height = 1;
    else if (ptr.left == null)
        ptr.height = ptr.right.height + 1;
    else if (ptr.right == null)
        ptr.height = ptr.left.height + 1;
    else 
        ptr.height = ptr.left.height + ptr.right.height + 1;
}

void insert(int val, int pos)
{
    this.root = insertNode(this.root, val, pos);
}


}


class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        
        List<Integer> result = new ArrayList<Integer>();
        BinaryTree tree = new BinaryTree(nums.length);

        for (int i = nums.length - 1; i >= 0; i--)
        {
            tree.insert(nums[i], i);
            result.add(tree.count[i]);
        }

        Collections.reverse(result);

        return result;
    }


    
}



public class App {
    public static void main(String[] args) throws Exception {
        
       Solution solution = new Solution();

       solution.countSmaller(new int [] {2, 0, 1});

    }
}
