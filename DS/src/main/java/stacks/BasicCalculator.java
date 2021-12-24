package stacks;

import java.util.Stack;

class BasicCalculator {

    public static void main(String[] args) {
        String s = "- (3 + (4 + 5))";
        BasicCalculator basicCalculator = new BasicCalculator();
        System.out.println(basicCalculator.calculate(s));
    }

    public int calculate(String s) {
        s = s.trim();

        int sign = 1;
        Boolean prevOperatorIsPlus = null;
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)){
                int sum = c-'0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    sum = sum*10 + s.charAt(i+1) - '0';
                    i++;
                }
                result += sum*sign;
            }else if(c.equals('+')){
                sign = 1;
            } else if(c.equals('-')){
                sign = -1;
            } else if(c.equals('(')){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(c.equals(')')){
                int sig = stack.pop();
                int val = stack.pop();
                result = val + result*sig ;
            }

        }
        return result ;
    }

    private boolean isOperator(Character ch){
        if(ch.equals('+') || ch.equals('-')){
            return true;
        }
        return false;
    }
}