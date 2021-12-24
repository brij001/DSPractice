package arrays;

import java.util.Map;
import java.util.Stack;

public class LongestValidParanthesis {
	
	
	public static void main(String args[]){
		System.out.println(longestValidParentheses("()(()))())()"));
		System.out.println(longestValidParenMethod2("()()"));
	}
	
	public static int longestValidParentheses(String ss) {
        
	     Stack<Integer> s = new Stack<Integer>();

	    char []c = ss.toCharArray();
	        for(int i=0;i<c.length;i++){

	            if(c[i]==')' && !s.isEmpty() && c[s.peek()]=='('){
	               s.pop();
	               
	            } else{
	                s.push(i);
	            }
	        }
	        
	        int top = c.length;
	        int prev = 0;
	        int larg = 0;
	        
	        if(s.isEmpty())
	        	larg=top;
	        
	        while(!s.isEmpty()){
	        	prev = s.peek();
	            larg = Math.max(larg,top-prev-1);
	            top = prev;
	            s.pop();
	        } 
	        
	        larg = Math.max(larg,top);
	        
	         
	        return larg;
	    }


	    public static int longestValidParenMethod2(String ss){

			Stack<Integer> stack = new Stack<Integer>();
			char c[] = ss.toCharArray();
			stack.push(-1);
			int longestValidParam = 0;
			for(int i=0;i<c.length;i++){
				int top = stack.peek();
				if(c[i]==')'&& !stack.isEmpty() && top!=-1 && c[stack.peek()]=='('){
					stack.pop();
					longestValidParam = Math.max(longestValidParam,i-stack.peek());
				} else {
					stack.push(i);
				}
			}
		 	return longestValidParam;

		}


}
