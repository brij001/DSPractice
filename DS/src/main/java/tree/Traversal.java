package tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
	
	public Node n;
	int sum;
	
	static class Node{
		
		int data;
		Node left, right;
		
		public Node(int item){
			left= null;
			right = null;
			data = item;
		}
		
	}

	public static void main(String args[]){
		
		Traversal t = new Traversal();
		t.n= new Node(10);
		t.n.left = new Node(15);
		t.n.right = new Node(20);
		t.n.left.left = new Node (25);
		t.n.left.right = new Node (30);
		t.n.right.left = new Node (35);
		t.n.right.right = new Node (40);
		t.n.left.left.left = new Node (45);
		t.n.left.right.left = new Node (50);
		t.n.left.right.left.right = new Node (55);
		
		//inorder(t.n);
		//preorder(t.n);
		//postorder(t.n);
		//leafs(t.n);
		
		//System.out.println(findParent(t.n, 50).data);
		//System.out.println(findParentOld(t.n, t.n,50).data);
		//System.out.println(findHeight(t.n));
		levelOrder(t.n);
		
		int path[] = new int[500];
		printAllPathsFromRootToLeaves(t.n, path, 0);

		//System.out.print("HEllo");
		t.printPathsWithGivenSum2(t.n,path,0,65);
		
		
		//t.leftViewUtil(t.n, 1);
		
	}

	
	public static void printAllPathsFromRootToLeaves(Node n, int path[], int pl){
		if(n==null){
			return ;
		}
		path[pl++]=n.data;
		if(n.left==null && n.right==null){
			for(int i=0;i<pl;i++){
				System.out.print(path[i]+ " ");
			}
			System.out.println();
		}
		
		printAllPathsFromRootToLeaves(n.left, path, pl);
		printAllPathsFromRootToLeaves(n.right, path, pl);
	}
	
	
	public static int findHeight(Node n){
		if(n==null){
			return 0 ;
		}

		int leftHt = findHeight(n.left);
		int rightHt = findHeight(n.right);
		return Math.max(leftHt, rightHt)+1;

	}

	public static Node findParent(Node n, int item){
		if(n==null){
			return n;
		}
		System.out.println("Current Track : "+n.data);
		if(n.left!=null && n.left.data==item || n.right!=null && n.right.data==item) {
			System.out.println("Matched Parent: "+n.data);
			return n;
		}

		Node leftResult = findParent(n.left, item);
		if(leftResult != null) {
			return leftResult;
		} else  {
			return findParent(n.right,item) ;
		}

	}

// Wrong - No proper result
	public static Node findParentOld(Node n, Node parent, int item){
		if(n==null){
			return n;
		}
		System.out.println("Current Track : "+n.data);
		 if(n.data==item)
			 return parent;
		if(findParentOld(n.left, n, item)!=null) {
			System.out.println("N : "+n.data);
			return n; 
		}
		System.out.println("Left's Right : "+n.data);
		if(findParentOld(n.right, n, item)!=null) {
			System.out.println("N : "+n.data);
			return n; 
		}
		return null;
	}
	
	static int  max_level = 0; 
	
	void leftViewUtil(Node node, int level) 
    { 
        // Base Case 
        if (node==null) return; 
  
        // If this is the first node of its level 
        if (max_level < level) 
        { 
            System.out.print(" " + node.data); 
            max_level = level; 
        } 

        // Recur for left and right subtrees 
        leftViewUtil(node.left, level+1);
        leftViewUtil(node.right, level+1);
    } 
	
	
	public static void levelOrder(Node n){
		int height = findHeight(n);

		for(int i=0;i<height;i++){
			printLevelOrder(n, i);
		}
	}


	public Node parent(Node root, Node n){
		if(root==null || n==null){
			return root;
		}

		if( (root.left!=null && root.left == n) || (root.right!=null && root.right== n )){
			return n;
		}

		return parent(root.left, n)!=null? parent(root.left, n) : parent(root.right,n);
	}
	
	public static void printLevelOrder(Node n , int level){
		if(n==null)
			return ;
		if(level==0) {
			System.out.println(n.data);
		}
		printLevelOrder(n.left, level-1);
		printLevelOrder(n.right, level-1);
	}
	
	public static void inorder(Node n){
		
		if(n==null )
			return;
		inorder(n.left);
		System.out.println("Data : "+n.data);
		inorder(n.right);
	}

	public static void leafs(Node n){

		if(n==null )
			return;

		if(n.left==null && n.right==null){
			System.out.println("Datas : "+n.data);
		}
		leafs(n.left);
		leafs(n.right);
	}

	public static void preorder(Node n){
		
		if(n==null)
			return;

		System.out.println("Predorder Data : "+n.data);
		preorder(n.left);
		preorder(n.right);
	}
	
	public static void postorder(Node n){
		if(n==null)
			return;
		postorder(n.left);
		postorder(n.right);
		System.out.println("PostOrder data : "+n.data);
	}

	Stack<Integer> s = new Stack<Integer>();

	// sum anywhere in path
	public void pathWithGivenSum(Node n, int k){
		if(n==null)
			return;

		sum = sum+n.data;
		s.add(n.data);
		if(sum==k){
			String values = Arrays.toString(s.toArray());
			System.out.println(values);
		}
		pathWithGivenSum(n.left,k);

		pathWithGivenSum(n.right,k);

		sum = sum - s.pop();
	}

	// sum from root to leaf
	public static void printPathsWithGivenSum2(Node n, int path[], int pl,int sum){
		if(n==null){
			return ;
		}
		path[pl++]=n.data;
		sum = sum-n.data;
		if(n.left==null && n.right==null && sum == 0){
			for(int i=0;i<pl;i++){
				System.out.print(path[i]+ " ");
			}
			System.out.println();
		}

		printPathsWithGivenSum2(n.left, path, pl,sum);
		printPathsWithGivenSum2(n.right, path, pl, sum);
	}



	Node mirror(Node node)	{
		if (node == null)
			return node;

		/* do the subtrees */
		Node left = mirror(node.left);
		Node right = mirror(node.right);

		/* swap the left and right pointers */
		node.left = right;
		node.right = left;

		return node;
	}


	public boolean isBalanced(Node root) {
		return dfsHeightWithBalancedCheck(root) != -1;
	}
	int dfsHeightWithBalancedCheck(Node root) {
		if (root == null) return 0;

		int leftHeight = dfsHeightWithBalancedCheck(root.left);
		if (leftHeight == -1) return -1;
		int rightHeight = dfsHeightWithBalancedCheck(root.right);
		if (rightHeight == -1) return -1;

		if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public boolean hasPathSum(Node root, int targetSum) {
		if(root==null){
			return false;
		}
		targetSum = targetSum - root.data;

		if(targetSum==0 && root.left ==null && root.right == null){
			return true;
		}
		return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
	}


	List<List<Integer>> zigZagList = new ArrayList<>();
	private void zigZag(Node root, List<List<Integer>> zigZagList) {
		Stack<Node> mainStack = new Stack<>();
		Stack<Node> suppStack = new Stack<>();
		Node curr = null;
		mainStack.push(root);
		int level = 1;

		while(!mainStack.isEmpty()) {
			List<Integer> levelList = new ArrayList<Integer>();
			while(!mainStack.isEmpty()) {
				curr = mainStack.pop();
				levelList.add(curr.data);
				if(level%2!=0) {
					if(curr.left!=null)
						suppStack.push(curr.left);
					if(curr.right!=null)
						suppStack.push(curr.right);
				} else{
					if(curr.right!=null)
						suppStack.push(curr.right);
					if(curr.left!=null)
						suppStack.push(curr.left);
				}
			}

			mainStack = suppStack;
			suppStack = new Stack<>();
			level++;
			zigZagList.add(levelList);
		}
	}


	public List<List<Integer>> zigzagLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

		if(root == null) return wrapList;

		queue.offer(root);
		boolean flag = true;
		while(!queue.isEmpty()){
			int levelNum = queue.size();
			List<Integer> subList = new ArrayList<Integer>(levelNum);
			for(int i=0; i<levelNum; i++) {
				if(queue.peek().left != null) queue.offer(queue.peek().left);
				if(queue.peek().right != null) queue.offer(queue.peek().right);
				Node n = queue.poll();
				if(flag == true) subList.add(n.data);
				else subList.add(0, n.data);
			}
			flag = !flag;
			wrapList.add(subList);
		}
		return wrapList;
	}
}
