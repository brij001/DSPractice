package sorting;

public class MergeSortLinkedList {

	Node head = null;

	public static void main(String[] args) {

		MergeSortLinkedList li = new MergeSortLinkedList();
		li.push(51);
		li.push(152);
		li.push(50);
		li.push(192);
		li.push(122);
		li.push(2);
		//li.push(81);
		li.printList();

		// Apply merge Sort
		li.head = li.mergeSortLists(li.head); // Important to initialize head
		//li.head=li.deleteEvens(li.head);
		System.out.print("\n Sorted Linked List is: \n");
		li.printList();
	}
	
	
	public Node mergeSortLists(Node newHead) {

		if (newHead == null || newHead.next == null) {
			return newHead;
		}

		Node mid = findMiddle(newHead);
		Node midNextPlusOne = mid.next;
		mid.next = null;

		Node left = mergeSortLists(newHead);
		Node right = mergeSortLists(midNextPlusOne);

		Node sortedList = mergeList(left, right);
		return sortedList;

	}


	public Node mergeList(Node a, Node b) {
		Node temp = new Node();
		Node init = temp;
		while (a != null && b != null) {
			if (a.val < b.val) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}

		temp.next = (a == null) ? b : a;

		return init.next;
	}



	public Node deleteEvens(Node root){
		Node temp = root;
		Node nextNode = root.next;
		Node newHead = temp;
		
		while(nextNode!=null ){
			if(nextNode.val%2==0){
				nextNode= nextNode.next;
			}else{
				temp.next=nextNode;
				temp = temp.next;
				nextNode= nextNode.next;
			}
		}
		
		temp.next = nextNode;
		
		
		if(newHead.val%2==0)
			newHead = newHead.next;
		
		return newHead;

		
	}

	
	public Node findMiddle(Node head) {
		Node slowPoninter = head;
		Node fastPointer = head;

		while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPoninter = slowPoninter.next;
		}
		return slowPoninter;
	}

	void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println("Data : " + temp.val);
			temp = temp.next;
		}
	}

	
	
}






class Node {
	int val;
	Node next;

	public Node(int val) {
		this.val = val;
	}

	public Node() {

	}
}
