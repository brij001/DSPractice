package Demo;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        String ss = "abcabcbb";
        Solution s = new Solution();
        String str = "ab";
        String p = ".*c";
        System.out.println(s.isMatch(str, p));
        //System.out.println(s.lengthOfLongestSubstring(ss));

    }
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i=0, j=0;
        int len = s.length();
        Character ch = null ;
        while(true){

            // acquire
            while(j< len){
                ch = s.charAt(j);
                int val = map.getOrDefault(ch,0);
                map.put(ch, val+1);
                j++;
                if(val > 0)
                    break;

                result = Math.max(result,j-i);
            }

            // release
            while(i<j && i< s.length()){

                ch = s.charAt(i);
                int r = map.get(ch);
                if(r==1)
                    map.remove(ch);
                else
                    map.put(ch, --r);
                i++;
                if(!isStillRepeating(map))
                    break;
            }
            if(j==len)
                break;
        }

        return result;
    }

    private boolean isStillRepeating(Map<Character, Integer> map){

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() > 1 ) {
                return true;
            }
        }
        return false;
    }


    public boolean isMatch(String s, String p) {

        if(p.length()==0){
            return s.length()==0;
        }

        if(p.length()>1 && p.charAt(1)=='*'){

            if(isMatch(s,p.substring(2))){
                return true;
            }
            if(s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.' ) ){
                return isMatch(s.substring(1), p);
            }

            if( s==null)
                return true;
            return false;
        }

        else {
            if( s.length()>0 && (p.charAt(0)==s.charAt(0)|| p.charAt(0)=='.') ){
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        }
    }
}