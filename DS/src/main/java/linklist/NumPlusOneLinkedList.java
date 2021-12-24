package linklist;

public class NumPlusOneLinkedList {

    static Node head1, head2;

    // Driver Code
    public static void main(String[] args) {
        NumPlusOneLinkedList list = new NumPlusOneLinkedList();

        // creating first list
        head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        head2 = new Node(8);
        head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }

    Node addTwoLists(Node first, Node second) {
        // res is head node of the resultant list
        Node res = null;
        Node prev = null;
        Node temp = null;
        int carry = 0, sum;

        // while both lists exist
        while (first != null || second != null) {

            sum = carry + (first != null ? first.data : 0)
                    + (second != null ? second.data : 0);

            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;

            temp = new Node(sum);

            // if this is the first node then set it as head of the resultant list
            if (res == null) {
                res = temp;
            } else {
                prev.next = temp;
            }

            prev = temp;

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (carry > 0) {
            temp.next = new Node(carry);
        }
        // return head of the resultant list
        return res;
    }
    /* Utility function to print a linked list */

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}

// this code has been contributed by Mayank Jaiswal
