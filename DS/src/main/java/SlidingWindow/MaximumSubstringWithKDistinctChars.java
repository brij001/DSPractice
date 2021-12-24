package SlidingWindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// https://www.youtube.com/watch?v=Lav6St0W_pQ
public class MaximumSubstringWithKDistinctChars {

    public static void main(String args[]){
        String s = "abcbdbdbbdcdabd";// "abcfabcb";
        int k = 5;
        System.out.println(getSubStringWithKDistinctChars(s,k));
    }

    public static int getSubStringWithKDistinctChars(String s, int k){

        char arr[] = s.toCharArray();
        int j=0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        LinkedList<Character> list = new LinkedList<Character>();
        int maxCount = Integer.MIN_VALUE;
        String maxString = null;

        for(int i=0; i<arr.length; i++){
            if(map.size()<k || map.containsKey(arr[i])){
                map.put(arr[i], map.getOrDefault(arr[i],0)+1);

            } else if(map.size()>=k && !map.containsKey(arr[i])){
              while(map.size()>=k){
                  char frontCharacter = list.removeFirst();
                  int count = map.get(frontCharacter);
                  if(count-1==0)
                      map.remove(frontCharacter);
                   else
                       map.put(frontCharacter,map.get(frontCharacter)-1);
              }
                map.put(arr[i],1);
            }

            list.add(arr[i]);

            // This if block is just to print the maxStrings
            if(maxCount<list.size()){
                StringBuilder sb = new StringBuilder();
                for(Character c : list){
                    sb.append(c);
                }
                maxString = sb.toString();
            }

            maxCount = Math.max(maxCount,list.size());
        }
        System.out.println("MaxString : "+maxString);
        return maxCount;
    }
}
