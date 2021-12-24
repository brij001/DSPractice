package tree;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class TreeFromTraversals {

	Node n;
	static int pre = 0;
	static int post;
	static class Node {
		
		Node left, right ;
		int data;
		
		Node(int data){
			this.data= data;
		}
	}
	
	public static void main(String args[]){
		
		TreeFromTraversals t = new TreeFromTraversals();
	
		/**t.n= new Node(10);
		t.n.left = new Node(15);
		t.n.right = new Node(20);
		t.n.left.left = new Node (25);
		t.n.left.right = new Node (30);
		**/
		
		int inorder[] = {25,15,30,10,20};
		int preorder[] = {10,15,25,30,20};
		//int postorder[] = {25,30,15,20,10};
		//post = postorder.length-1;
		
		//t.n = createTreeFromInAndPost(inorder, postorder, 0, inorder.length-1);
		t.n = t.createTreeFrmInAndPRE(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
				
		
		//postorderT(t.n);
		preorder(t.n);
		//inorder(t.n);
		
	}
	

	public static Node createTreeFromInAndPost(int[] inorder, int[] postorder, int start, int end, int pStart, int pEnd){
		
		if(start>end)
			return null;
		
		Node n = new Node(postorder[pEnd]);
		
		if(start==end)
			return n;
		
		int indexOfNinInorder = findIndex(inorder, n.data);
		
		n.left = createTreeFromInAndPost(inorder, postorder, start, indexOfNinInorder-1, pStart, pStart+indexOfNinInorder-start-1);
		n.right = createTreeFromInAndPost(inorder, postorder, indexOfNinInorder+1, end,  pStart+indexOfNinInorder-start, pEnd-1);
		return n;
		
	}
	
	
	
	

	public static Node createTreeFrmInAndPRE(int[] inorder, int[] preorder, int start, int end, int pStart, int pEnd){
		
		if(start>end)
			return null;
		
		Node nNode = new Node(preorder[pStart]);
		int indexofCharNode = findIndex(inorder, nNode.data);
		
		if (start == end) 
            return nNode;
		// length of inorder and preorder will be same so,  pEnd - pStart = iEnd - iStart ;
		nNode.left = createTreeFrmInAndPRE(inorder, preorder, start, indexofCharNode-1, pStart+1, pStart+indexofCharNode-start-1);
		nNode.right = createTreeFrmInAndPRE(inorder, preorder, indexofCharNode+1, end, pStart+indexofCharNode-start, pEnd);
		return nNode;
	}

	
	
	
		
	public static void postorderT(Node n){
		if(n==null)
			return;
		postorderT(n.left);
		postorderT(n.right);
		System.out.print(" "+n.data);
	}
	
	public static int findIndex(int[] arr, int data){
		for(int i=0;i<arr.length;i++)
			if(arr[i]==data)
				return i;
		
		return 0;
	}
	
	public static void preorder(Node n){
		
		if(n==null)
			return;

		System.out.println("Predorder Data : "+n.data);
		preorder(n.left);
		preorder(n.right);
	}
	
	public static void inorder(Node n){
		
		if(n==null )
			return;
		inorder(n.left);
		System.out.println("Data : "+n.data);
		inorder(n.right);
	}
}
