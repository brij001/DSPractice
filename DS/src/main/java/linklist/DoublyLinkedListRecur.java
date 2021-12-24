package linklist;

public class DoublyLinkedListRecur {

   static Node head = null;
    // a node of the doubly linked list
    static class Node
    {
        int data;
        Node next, prev;
    };

    // Driver code
    public static void main(String args[])
    {
        // Start with the empty list


        // Create doubly linked: 10<.8<.4<.2 /
        head = push(head, getNode(2));
        head = push(head, getNode(4));
        head = push(head, getNode(8));
        head = push(head, getNode(10));
        System.out.print( "Original list: ");
        printList(head);

        // Reverse doubly linked list
        head = reverse(head);
        System.out.print("\nReversed list: ");
        printList(head);
    }

    // function to reverse a doubly linked list
    static Node reverse(Node node)
    {
        // If empty list, return
        if (node == null)
            return null;

        // Otherwise, swap the next and prev
        Node temp = node.next;
        node.next = node.prev;
        node.prev = temp;

        // IMPORTANT CONDITION
        // If the prev is now null, the list
        // has been fully reversed
        if (node.prev == null)
            return node;

        // Otherwise, keep going
        return reverse(node.prev);
    }

    // Function to print nodes in a given doubly
// linked list
    static void printList(Node head)
    {
        while (head != null)
        {
            System.out.print( head.data + " ");
            head = head.next;
        }
    }

    static Node push(Node headRef, Node newNode)    {
        newNode.prev = null;
        newNode.next = (headRef);

        if ((headRef) != null)
            (headRef).prev = newNode;
        (headRef) = newNode;
        return headRef;
    }

    // function to get a new node
    static Node getNode(int data) {
        Node new_node = new Node();
        new_node.data = data;
        new_node.next = new_node.prev = null;
        return new_node;
    }


}

// This code is contributed by Arnab Kundu

