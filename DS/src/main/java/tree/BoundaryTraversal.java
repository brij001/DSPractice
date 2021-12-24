package tree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    private void practice(){
        // if !=leaf then addLeft
        // add leaves
        // add right if !=leaf
    }
    List<Integer> printBoundary(Node node)    {
        List<Integer> ans = new ArrayList<Integer>();
        if(isLeaf(node) == false) ans.add(node.data);
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;
    }

    void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (isLeaf(curr) == false) res.add(curr.data);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    void addRightBoundary(Node root, List<Integer> res) {
        Node curr = root.right;
        List<Integer> tmp = new ArrayList<>();
        while (curr != null) {
            if (isLeaf(curr) == false) tmp.add(curr.data);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        int i;
        for (i = tmp.size()-1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    void addLeaves(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }



    Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }


}
