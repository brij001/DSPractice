package linklist;

public class FlatteningLinkedList {

    Node head; // head of list

    /* Driver program to test above functions */
    public static void main(String args[]) {
        FlatteningLinkedList L = new FlatteningLinkedList();

		/* Let us create the following linked list
			5 -> 10 -> 19 -> 28
			| |	 |	 |
			V V	 V	 V
			7 20 22 35
			|		 |	 |
			V		 V	 V
			8		 50 40
			|			 |
			V			 V
			30			 45
		*/

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }


    Node merge(Node a, Node b) {

        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        result.right = null;
        return result;
    }

    Node flatten(Node root) {
        if (root == null || root.right == null)
            return root;

        root.right = flatten(root.right);

        root = merge(root, root.right);
        // return the root
        // it will be in turn merged with its left
        return root;
    }


    Node push(Node headRef, int data) {
		/* 1 & 2: Allocate the Node &
				Put in the data*/
        Node newNode = new Node(data);
        /* 3. Make next of new Node as head */
        newNode.down = headRef;
        /* 4. Move the head to point to new Node */
        headRef = newNode;
        /*5. return to link it back */
        return headRef;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }

    /* Linked list Node*/
    class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }
} /* This code is contributed by Rajat Mishra */
