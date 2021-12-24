package tree;

// https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=50
public class DiameterOfTree {

    // Driver code
    public static void main(String[] args)
    {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);

        System.out.println("Diameter is " + diameter(root));
    }



    // Optimized, finding the diameter via height function
    static int height(Node root, A a)
    {
        if (root == null)
            return 0;

        int left_height = height(root.left, a);

        int right_height = height(root.right, a);

        // update the answer, because diameter of a tree is nothing but maximum value of
        // (left_height + right_height + 1) for each node
        a.ans = Math.max(a.ans, 1 + left_height +
                right_height);

        return 1 + Math.max(left_height, right_height);
    }


    // Unoptimized
    static int  max = 0;
    public static int unoptimizedDia(Node root){
        if(root==null)
            return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        return Math.max(max, 1+lh+rh);
    }

    static int findHeight(Node root){
        if(root==null)
            return 0;
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        return 1 + Math.max(lh, rh);
    }











    static int diameter(Node root)   {
        if (root == null)
            return 0;

        // This will store the final answer
        A a = new A();
        int height_of_tree = height(root, a);
        return a.ans;
    }

    static Node newNode(int data)
    {
        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return (node);
    }

    /* Tree node structure used in the program */
    // Diameter = Maximum length from any leave node to any leaf node
    static class Node
    {
        int data;
        Node left, right;
    }

    static class A
    {
        int ans = Integer.MIN_VALUE;
    }



}

// This code is contributed by Prerna Saini.
