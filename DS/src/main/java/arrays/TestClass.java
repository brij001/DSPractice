package arrays;

import java.util.*;

public class TestClass {
    List<Integer> list;

    public TestClass(){
        list = new ArrayList<Integer>();
    }

    public static void main(String...s){
         StringBuffer sb = new StringBuffer("Hello");
        sb = new StringBuffer("Hello2");
        sb.append("hi");
        System.out.println(sb);

        String A = "Test";
        String B = "Test";

        A.toUpperCase(); // but   A.toUpperCase(); a new object ("TEST") will be created
        System.out.println(A);
        System.out.println(B);
        //Read more: https://javarevisited.blogspot.com/2010/10/why-string-is-immutable-or-final-in-java.html#ixzz6hoW7uuBq

        TestClass t = new TestClass();
        t.addNum(1);t.addNum(2); t.addNum(3);
        System.out.println(t.findMedian());
    }

    public void addNum(int num) {
        list.add(num);
    }
    public double findMedian() {
        int size = list.size();
        Collections.sort(list);
        if(size==1)
            return list.get(0);

        if(size%2!=0)
            return list.get(size/2 );
        else
            return  (double) (list.get(size/2) + list.get(size/2 -1))/2 ;

    }

    public static void main1(String args[])
    {

        // Creating a vector object
        ArrayList<Integer> v = new ArrayList<Integer>();

        // Adding elements to the vector object
        v.add(10);
        v.add(20);
        v.add(30);
        v.add(40);
        v.add(50);

        System.out.println("Enumeration: ");


        System.out.println("Iterator: ");

        // Creating Iterator object
        Iterator<Integer> itr = v.iterator();

        // Checking the next element availability
        while (itr.hasNext()) {

            // Moving cursor to the next element
            int i = (Integer)itr.next();
            // Checking if i == 10 then
            // remove the element
            if (i == 10)
                itr.remove();
        }
        System.out.println(v);
        System.out.println();

        System.out.println("ListIterator: ");

        // Creating ListIterator object
        ListIterator<Integer> ltr = v.listIterator();

        // Checking the next element availability
        while (ltr.hasNext()) {

            // Moving cursor to the next element
            int i = (Integer)ltr.next();

            // Performing add, remove, and
            // replace operation
            if (i == 20)
                ltr.remove();

            else if (i == 30)
                ltr.add(60);

            else if (i == 40)
                ltr.set(100);
        }

        System.out.println(v);
    }
}
