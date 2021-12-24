package dp;

public class WildcardPattern {
    // global dp array
    Boolean dp[][];

    public static void main(String args[])
    {
        String str = "baaabab";
        String pattern = "*****ba*****ab";
        // String pattern = "ba*****ab";
        // String pattern = "ba*ab";
        // String pattern = "a*ab";
        // String pattern = "a*****ab";
        // String pattern = "*a*****ab";
        // String pattern = "ba*ab****";
        // String pattern = "****";
        // String pattern = "*";
        // String pattern = "aa?ab";
        // String pattern = "baaabab";
        // String pattern = "?baaabab";

        WildcardPattern wildcardPattern = new WildcardPattern();
        if (wildcardPattern.wm(str, pattern, str.length(),pattern.length()))
            System.out.println("Yes");
        else
            System.out.println("No");
    }


    boolean wm(String s , String p , int i , int j){
        // if we reach end of both string simultaneously return true
        if(s.length()==i && p.length() == j) return true;


        //if string s has ended we need to check that remaining characters in p are all asteriks.
        if(i == s.length()){
            for(int index = j;index<p.length();index++){
                if(p.charAt(index)!='*'){
                    return false;
                }
            }
            return true;
        }

        //if string p has ended and s still remains , there is no way to match, think think!
        if(j == p.length() && i!=s.length())return false;

        //if sub problem already solved return it
        if(dp[i][j]!=null)return dp[i][j];

        boolean ans = false;

        if(p.charAt(j)=='?'){
            //using ? as a single character(go ahead in both s and p )
            if(wm(s,p,i+1,j+1)){
                ans = true;
            }

        }
        else if(p.charAt(j)=='*'){
            //using * as empty string (go ahead in just p)
            if(wm(s,p,i,j+1)){
                ans = true;
            }
            //using * as multiple characters(go ahead in s but not p)
            if(wm(s,p,i+1,j)){
                ans = true;
            }
            // using * as single character(go ahead in both s and p)
            if(wm(s,p,i+1,j+1)){
                ans   = true;
            }

        }
        //if both i and j have characters then if they match go ahead in both else ans is false by default
        else if(p.charAt(j)==s.charAt(i) && wm(s,p,i+1,j+1)){
            ans= true;
        }
        dp[i][j] = ans;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return wm (s , p , 0 , 0);
    }
}