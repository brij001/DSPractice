package arrays;

import java.util.Scanner;
import java.util.Stack;

public class WAP {
    // Rearrange an array in maximum minimum form | (O(1) extra space - https://www.youtube.com/watch?v=KOglcclYgXI
    public static void main(String []argh)
    {
        //Scanner sc = new Scanner(System.in);
        int i=0;
        String sss = "{}(";
        char[] sc = sss.toCharArray();

        Stack<String> stack = new Stack<String>();

        while (i<sc.length) {

            String input= String.valueOf(sc[i]);
            //Complete the code
            i++;

            if(input.equals("{") ||input.equals("(") || input.equals("[") ){
                stack.add(input);
            } else {
                if(!stack.isEmpty()) {
                    String closing = stack.peek();
                    if(input.equals("}") && closing.equals("{")){
                        stack.pop();
                    } else if(input.equals(")") && closing.equals("(")){
                        stack.pop();
                    } else if(input.equals("]") && closing.equals("[")){
                        stack.pop();
                    }
                } else{
                    System.out.println("false");
                }
            }
        }

        if(stack.isEmpty()){
            System.out.println("true");
        } else{
            System.out.println("false");
        }


    }



}
