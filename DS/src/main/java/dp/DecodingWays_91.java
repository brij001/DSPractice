package dp;

// https://leetcode.com/problems/decode-ways/
// "12" could be decoded as "AB" (1 2) or "L" (12).
public class DecodingWays_91 {

    public int decode(int index, String str, Integer[] arr){
        if(index==str.length())
            return 1;

        if(str.charAt(index)=='0')
            return 0;

        if(arr[index]!=null) // To Memoize the things
            return arr[index];

        int res1 = decode(index+1, str, arr);
        int res2 = 0;
        if( (index+2)<=str.length() && Integer.parseInt(str.substring(index,index+2)) <= 26 )
            res2 = decode(index+2, str, arr);

        return arr[index] = res1+res2;
    }


    public int numDecodings(String s) {
        if(s==null || s.trim().length()<=0 || s.charAt(0)=='0' )
            return 0;

        int dp[] = new int[s.length()];
        dp[0] = 1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1)=='0' && s.charAt(i)=='0'){ // 00
                dp[i] = 0;
            } else if(s.charAt(i-1)!='0' && s.charAt(i)=='0'){ // 20
                int val = Integer.parseInt(s.substring(i-1,i+1));
                if(i>1)
                    dp[i] = val<=26?dp[i-2]:0;
                else
                    dp[i] = val<=26?1:0;
            } else if(s.charAt(i-1)=='0' && s.charAt(i)!='0'){ // 05
                dp[i] = dp[i-1];
            } else{                                           // 22
                int val = Integer.parseInt(s.substring(i-1,i+1));
                if(i>1)
                    dp[i] = val<=26?dp[i-2]+dp[i-1]:dp[i-1];
                else
                    dp[i] =  val<=26?dp[i-1]+1:dp[i-1];

            }
        }
        return dp[s.length()-1];
    }

}
