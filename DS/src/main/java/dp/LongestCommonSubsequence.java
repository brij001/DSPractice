package dp;

public class LongestCommonSubsequence {

    public int lcs(char str1[],char str2[],int len1, int len2){
        
        if(len1 == str1.length || len2 == str2.length){
            return 0;
        }
        if(str1[len1] == str2[len2]){
            return 1 + lcs(str1,str2,len1+1,len2+1);
        }
        else{
            return Math.max(lcs(str1,str2,len1+1,len2),lcs(str1,str2,len1,len2+1));
        }
    }

    public int lcsDynamic(char str1[],char str2[]){
    
        int dp[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i=1; i < dp.length; i++){
            for(int j=1; j < dp[i].length; j++){
                if(str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        
        // To print Actual Longest Common subsequence Chars
        int i=str1.length;
        int j = str2.length	;
        while ( i>=1 && j>=1){
        	while(j>=1 && dp[i][j]==dp[i][j-1]){
        		j--;
        	}

        	while(j>=1 && dp[i][j]==dp[i-1][j]){
        		i--;
        	}
        	System.out.print(str1[i-1]+ " " );
        	i--;
        	j--;
        }
        
        return max;
  
    }
    
    public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "acbcf";
        String str2 = "abcdaf";
        
        int result = lcs.lcsDynamic(str1.toCharArray(), str2.toCharArray());
        System.out.println();
        System.out.print("Length of LCS "+result);
    }
    
    
    
}
