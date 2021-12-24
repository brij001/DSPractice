package tree;

public class FlatteningTreeToLinkedList {

    BinaryTreeSerializeDeserialize.TreeNode prev = null;
    public void flatten(BinaryTreeSerializeDeserialize.TreeNode root) {
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}