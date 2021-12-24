package dp;

// https://leetcode.com/problems/remove-boxes/
class RemoveBoxes {
    int dp[][][];
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        dp = new int[len][len][len];
        return getAns(boxes,0,boxes.length-1,0);
    }

    private int getAns(int[] boxes, int l, int r, int count){
        if(l>r){
            return 0;
        }
        if(dp[l][r][count]!=0){
            return dp[l][r][count];
        }
        int ans =0;
        while(l<r && boxes[l]==boxes[l+1]){
            l++;
            count++;
        }
        ans = (count+1)*(count+1) + getAns(boxes,l+1, r, 0);
        int max = ans;
        for(int m=l+1; m<=r; m++){
            if(boxes[m]==boxes[l])
                max = Math.max(max, getAns(boxes,m,r,count+1) + getAns(boxes,l+1,m-1,0));
        }
        return dp[l][r][count]=max;
    }

}