package stacks;

import java.util.Stack;
import java.util.Arrays;

// https://www.geeksforgeeks.org/the-stock-span-problem/
public class SpanOfStocks {

    // A stack based efficient method to calculate
    // stock span values
    static void calculateSpan(int price[], int n, int S[])
    {

        Stack<Integer> st = new Stack<Integer>();
        st.push(0);

        S[0] = 1;

        for (int i = 1; i < n; i++) {

            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while (!st.empty() && price[st.peek()] <= price[i])
                st.pop();


            S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
            // Push this element to stack
            st.push(i);
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }

    // Driver method
    public static void main(String[] args)
    {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        printArray(S);
    }
}
