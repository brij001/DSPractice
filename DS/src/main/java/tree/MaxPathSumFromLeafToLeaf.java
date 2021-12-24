package tree;


// https://www.youtube.com/watch?v=FxgpgxH2k8o
public class MaxPathSumFromLeafToLeaf {

    static Node root;

    int maxPathSumUtil(Node node, Res res) {

        // Base cases
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;

        int ls = maxPathSumUtil(node.left, res);
        int rs = maxPathSumUtil(node.right, res);

        // If both left and right children exist
        // [For binary tree, any node can have 3 cases : node has 0 children, node has 2 children or node has just 1 children]
        if (node.left != null && node.right != null) {
            // We are finding max in this block because we have to find max bw leaf to leaf, incase any of the child is null, path between leaf to leaf cannot be found
            res.val = Math.max(res.val, ls + rs + node.data);

            // Return maxium possible value for root being
            // on one side
            return Math.max(ls, rs) + node.data;
        }

        // If any of the two children is empty, return
        // root sum for root being on one side
        return (node.left == null) ? rs + node.data
                : ls + node.data;
    }

    // The main function which returns sum of the maximum
    // sum path between two leaves. This function mainly
    // uses maxPathSumUtil()
    int maxPathSum(Node node)
    {
        Res res = new Res();
        res.val = Integer.MIN_VALUE;
        maxPathSumUtil(root, res);
        return res.val;
    }

    //Driver program to test above functions
    public static void main(String args[]) {
        MaxPathSumFromLeafToLeaf tree = new MaxPathSumFromLeafToLeaf();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.maxPathSum(root));
    }

}


// Java program to find maximum path sum between two leaves
// of a binary tree
 class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
    int val;
}
