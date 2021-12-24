package tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class BinaryTreeSerializeDeserialize {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root==null)
                return null;
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode t = queue.poll();

                if(t==null){
                    sb.append("#,");
                    continue;
                }
                sb.append(t.val + ",");
                queue.add(t.left);
                queue.add(t.right);
            }

            return sb.toString();


        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data==null)
                return null;

            String[] arr = data.split(",");
            int i = 1;

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.add(root);

            while(i<arr.length){
                TreeNode parent = queue.poll();
                // Left Child
                if(!arr[i].equals("#")){
                    TreeNode t = new TreeNode(Integer.parseInt(arr[i]));
                    parent.left = t;
                    queue.add(t);
                }
                i++;
                if(!arr[i].equals("#")){
                    TreeNode t = new TreeNode(Integer.parseInt(arr[i]));
                    parent.right = t;
                    queue.add(t);
                }
                i++;

            }

            return root;
        }
    }



