package linklist;

public class RearrangeOddEven {
    static Node head;
    //Rearrange a linked list such that all even and odd positioned nodes are together
    // Input :  1->2->3->4->5->6->7
    // Output:  1->3->5->7->2->4->6
    public static void main(String...s){

        Node n1 = new Node(1);
        head = n1;
        n1.next = new Node(2);
        n1.next.next  = new Node(3);
        n1.next.next.next  = new Node(4);
        n1.next.next.next.next  = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next  = new Node(7);
        n1.next.next.next.next.next.next.next  = new Node(8);

        head = rearrange2(); // It's the easiest way
        printCurrentLinkList();
    }

   static class  Node {
        int data;
        Node next ;

        Node(int data){
            this.data=data;
        }
    }


    public static void printCurrentLinkList(){
        RearrangeOddEven.Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }


    /// Easier one -- this will make odd and even separate lists and then append even after the last odd list.
    public static Node rearrange2(){
        //  1->2->3->4->5->6->7->8

        if (head == null)
            return null;

        Node even = null ;
        Node odd = null;
        Node oddHead = null;
        Node evenHead = null;
        Node currentNode = head;
        int i = 1; // incase you want to check for even data instead of number, check the same (currentNode.data%2==0)
        while(currentNode!=null){
            if(i%2 !=0){
                if(odd==null || oddHead==null){
                    oddHead = currentNode;
                    odd = oddHead;
                } else{
                    odd.next = currentNode;
                    odd = odd.next;
                }
            } else {
                if(even==null || evenHead ==null){
                    evenHead = currentNode;
                    even = evenHead;
                } else {
                    even.next = currentNode;
                    even = even.next;
                }
            }
            currentNode = currentNode.next;
            i++;
        }

        odd.next = evenHead;
        even.next = null;

        return oddHead;
    }



}
