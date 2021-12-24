package linklist;

public class LinkList {
	
	Node head; 
	
	class Node {
		int data ;
		Node next;
		
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	
	public static void main(String args[]){
		LinkList l = new LinkList();
		l.insertNode(10);
		l.insertNode(20);
		l.insertNode(30);
		l.insertNode(40);
		l.insertNode(50);
		l.insertNode(60);
		
		l.reverseLinkListUsingRecursion(l.head);
		l.printCurrentLinkList();
	}
	
	
	public Node reverseLinkListUsingRecursion(Node n){
		if(n.next==null){
			head = n;
			return n;
		}
		
		Node nlast = reverseLinkListUsingRecursion(n.next);
		System.out.println("Nlast : "+nlast.data);
		nlast.next = n;
		//n.next.next = n;
		n.next=null;
		
		return n; // here we didn't return nlast because we are using nlast in next step(nlast.next=n) but since it keep on returning the same value for all the calls
		// while n in previous call will be different, so nlast.next = n ... it will result in 60.next = 50, 60.next = 40, 60.next=30 ...
	}
	
	public void printCurrentLinkList(){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		} 
		System.out.println("");
	}
	
	public void insertNode( int data){
		Node n = new Node(data);
		if(head!= null){
			Node temp = head;
			while(temp.next!=null){
				temp = temp.next;
			}
			temp.next = n;
		} else {
			head = n;
		}
	}


	Node localHead = null;
	Node localTail = null; // first tail
	Node finalHead = null; // final first head
	Node tempTail = null;
	Node nextNode = null;

	public Node reverseKGroup(Node head, int k) {
		Node reverseHead;

		int len = getLength(head) ;
		int count = len/k;
		nextNode = head;
		while(count>0){
			reverseList(nextNode,k);
			if(finalHead==null){
				finalHead = localHead;
				tempTail = localTail;
			} else{
				tempTail.next = localHead;
				tempTail = localTail;
			}
			count--;
		}

		localTail.next = nextNode;
		return finalHead;
	}



	public int getLength(Node head){
		Node curr = head;
		int len=0;
		while( curr!=null){
			curr = curr.next;
			len++;
		}
		return len;
	}


	public void reverseList(Node head , int k ){
		Node curr = head;
		Node prev = null;
		Node next = null;
		localTail = head;
		int i=0;
		while(curr!=null && i<k ){
			i++;
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		nextNode = next;
		localHead = prev;
	}



}
