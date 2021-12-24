package arrays;

import java.util.HashMap;
import java.util.Map;

// 76. Minimum Window Substring
public class MinimumWindowSubstring {


    public static void main(String ...ss){
        MinimumWindowSubstring s = new MinimumWindowSubstring();
        String st = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(s.minWindow(st, t));
    }

    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";

        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqCurrS = new HashMap<>();

        for(int i=0; i<t.length(); i++){
            Integer val = freqT.getOrDefault(t.charAt(i),0);
            freqT.put(t.charAt(i),val+1);
        }

        int i = 0;
        int j = 0;

        int desiredCount =  t.length();// freqT.size();
        int currCount = 0;
        String pAns = null;
        String ans = "";
        while(true){

            boolean f1 = false;
            boolean f2 = false;
            // acquire
            while(j < s.length() && currCount<desiredCount) {

                if(freqT.containsKey(s.charAt(j))) {
                    freqCurrS.put(s.charAt(j), freqCurrS.getOrDefault(s.charAt(j),0)+1 );
                    if(freqCurrS.get(s.charAt(j)) <= freqT.get(s.charAt(j))){
                        currCount++;
                    }
                }
                j++;
                f1 = true;
            }

            // release
            while(i<j && currCount == desiredCount) {
                // store potential ans
                pAns = s.substring(i,j);
                if(ans.isEmpty() || (pAns.length() <= ans.length())) {
                    ans = pAns;
                }

                if(freqT.containsKey(s.charAt(i))){
                    freqCurrS.put(s.charAt(i), freqCurrS.get(s.charAt(i))-1);
                }

                if(freqCurrS.getOrDefault(s.charAt(i),0) < freqT.getOrDefault(s.charAt(i),0)) {
                    currCount--;
                }
                i++;
                f2 = true;
            }

            if( f1==false && f2==false)
                break;


        }

        return ans;
    }
}
