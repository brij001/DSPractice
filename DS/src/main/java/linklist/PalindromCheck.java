package linklist;

public class PalindromCheck {
    static Node head;

    public static void main(String...s){

        Node n1 = new Node(3);
        head = n1;
        n1.next = new Node(2);
        n1.next.next  = new Node(1);
        n1.next.next.next  = new Node(2);
        n1.next.next.next.next  = new Node(3);
       // n1.next.next.next.next.next = new Node(2);
        //n1.next.next.next.next.next.next  = new Node(1);
       // n1.next.next.next.next.next.next.next  = new Node(4);
        Node secondHead = breakFromMiddle();
        System.out.println(isPalindrome(head,secondHead));

    }

   static class  Node {
        int data;
        Node next ;

        Node(int data){
            this.data=data;
        }
    }

    public static  Node breakFromMiddle() {
        Node slow = head;
        Node fast = head;
        Node newHead = null;
        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            if(fast!=null && fast.next==null){ // Meaning odd, avoid the middle element
                newHead = slow.next.next;
                slow.next= null; // slow.next= null; for this particular case in finding palindrom else - slow.next.next= null;
                break;
            } else if(fast==null){
                newHead = slow.next;
                slow.next = null;
                break;
            }
            slow = slow.next;
        }

        slow.next=null;
        System.out.println("Mid : "+newHead.data);
        return newHead;
    }


    public static Node reverseLinklist(Node node){
        Node head ;
        Node currentNode = node;
        Node previousNode=null;
        Node nextNode;

        while(currentNode!=null ){
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        node = previousNode;
        return previousNode;
    }

    public static void printCurrentLinkList(){
        PalindromCheck.Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    public static boolean isPalindrome(Node head1, Node head2){
        head2=reverseLinklist(head2);
        while(head1.next!=null || head2.next!=null){
            if((head1==null && head2!=null) || (head1!=null && head2==null))
                return false;
            else if(head1.data !=head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

}
