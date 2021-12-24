package Demo;

// https://leetcode.com/problems/remove-boxes/
class ComplexNumberMultiplication {
    int dp[][][];

    public static void main(String[] args) {
        ComplexNumberMultiplication s = new ComplexNumberMultiplication();
        int ii = 2147483647;
        System.out.println(ii);

        String num1 = "78+-76i";
        String num2 = "-86+72i";

        s.complexNumberMultiply(num1,num2);
    }
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        dp = new int[len][len][len];
        int ii = 2147483647;

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

    public String complexNumberMultiply(String num1, String num2) {
        String num1Comb[] = num1.split("\\+");
        String num2Comb[] = num2.split("\\+");


        int num1Real = Integer.parseInt(num1Comb[0]);
        int num2Real = Integer.parseInt(num2Comb[0]);
        int num1Img = Integer.parseInt(num1Comb[1].substring(0,num1Comb[1].length()-1));
        int num2Img = Integer.parseInt(num2Comb[1].substring(0,num2Comb[1].length()-1));


        int mulReal = num1Real * num2Real - num1Img * num2Img;
        int mulImg = num1Real*num2Img + num2Img*num1Real;

        return String.valueOf(mulReal)+"+"+mulImg+"i";



    }
}