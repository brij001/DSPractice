package string;

// Leetcode Hard 214
// You are given a string s. You can convert s to a palindrome by adding characters in front of it.
// Return the shortest palindrome you can find by performing this transformation.
public class ShortestPalindromeL214 {

    public static void main(String[] args) {
        String s = "abcd";
        ShortestPalindromeL214 shortestPal = new ShortestPalindromeL214();
        System.out.println(shortestPal.shortestPalindrome(s)); // dcbabcd
    }
    public String shortestPalindrome(String s) {
        if(s==null)
            return s;

        String rev = new StringBuilder(s).reverse().toString();

        String s1 = s + "#" + rev;

        int LPS[] = new int[s1.length()];

        int len = 0; // LPS[i-1]
        int i = 1;

        while(i<s1.length()){
            if(s1.charAt(i)==s1.charAt(len)){ // len = LPS[i-1]
                len++;
                LPS[i] = len;
                i++;
            } else {
                if(len>0){
                    len = LPS[len-1];
                } else{
                    i++; // LPS[i]=0;  len = 0;
                }
            }
        }
        System.out.println( LPS[s1.length()-1]);
        int revLen =  s.length()-LPS[s1.length()-1];
        return rev.substring(0,revLen)+s;
    }
}