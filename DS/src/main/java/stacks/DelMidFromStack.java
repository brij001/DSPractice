package stacks;

import java.util.Stack;

public class DelMidFromStack {

    // Deletes middle of stack of size
    // n. Curr is current item number
    static void deleteMid(Stack<Character> st,
                          int n, int curr)
    {

        if (st.empty() || curr == n)
            return;

        char x = st.pop();

        deleteMid(st, n, curr+1); // Here we haven't done curr++ rather we chose curr+1 as curr++ will change the value of curr variable so whenever the stack call will return, it will always have only one value which as assigned during curr++
        // for curr+1, it will return the previous value when the stack call comes back

        // Put all items back except middle
        if (curr != n/2)
            st.push(x);
    }

    // Driver function to test above functions
    public static void main(String args[])
    {
        Stack<Character> st =
                new Stack<Character>();

        // push elements into the stack
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
        st.push('5');
        st.push('6');
        st.push('7');

        deleteMid(st, st.size(), 0);

        // Printing stack after deletion
        // of middle.
        while (!st.empty())
        {
            char p=st.pop();
            System.out.print(p + " ");
        }
    }

}


