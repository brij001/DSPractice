package sorting;

public class LinkedList {

	Node head;
	
	
	
	class Node {
		int data ;
		Node next;
		
		Node(int data){
			this.data = data;
			next = null;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	
	
	public void printMiddle(){
		Node slowPoninter = head;
		Node fastPointer = head;
		
		while(fastPointer!=null && fastPointer.next!=null){
			fastPointer= fastPointer.next.next;
			slowPoninter = slowPoninter.next;
		}
		
		System.out.println("Middle Element : "+slowPoninter.data);
	}
	
	
	public void revList(){
		
		if(head==null || head.next==null)
			return;
		
		Node p1 = null;
		Node p2 = head;
		Node p3 = null ;
		
		while ( p2!=null){
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		head = p1;
	}
	
	
	 Node reverse(Node head) { 
        if(head == null) { 
            return head; 
        } 
  
        // last node or only one node 
        if(head.next == null) { 
            return head; 
        } 
  
        Node newHeadNode = reverse(head.next); 
  		System.out.println("Head"+newHeadNode.data);
		 System.out.println("Dat  "+head.data);
        // change references for middle chain 
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode; 
    } 
	
	public void push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	
	public void printList(){
		Node temp = head;
		while(temp!=null){
			System.out.println("Data : "+temp.data);
			temp = temp.next;
		}
	}
	
	 public static void main(String [] args) {
		 
	        LinkedList llist = new LinkedList(); 
	        for (int i=40; i>0; i=i-10)
	        { 
	            llist.push(i);
	            
	        } 
	        llist.head = llist.reverse(llist.head);
	        llist.printList(); 
	    } 
}


