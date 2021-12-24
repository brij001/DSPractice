package string;

import java.util.Arrays;

// Count number of substrings with exactly k distinct characters
public class CountKSubStr {

    public static void main(String[] args)   {
        CountKSubStr ob = new CountKSubStr();
        String ch = "abcbaa";
        int k = 3;
        System.out.println("Total substrings with exactly " +
                k +    " distinct characters : "
                + ob.countkDist(ch, k));
    }

    int countkDist(String str, int k) {

        // Initialize result
        int res = 0;

        int n = str.length();
        int count[] = new int[26];

        for(int i=0;i<str.length();i++){
            int k_distinct_count = 0;
            Arrays.fill(count, 0);

            for(int j=i;j<str.length();j++){


                if(count[str.charAt(j)-'a']==0){
                    k_distinct_count++;
                }
                count[str.charAt(j)-'a']++;

                if(k==k_distinct_count)
                    res++;

            }
        }

        return res;
    }




}
