package dp;

public class KnapsackProblem {
	static int temp[][] = null;
	
	public static void main(String[] args) {
		int knapsackMaxWeight = 5;
		int profit[] = {200, 240, 140, 150};
		int weight[] = {1, 3, 2, 5};

		int maxProfit = maximizeProfit(weight, profit, knapsackMaxWeight);
		System.out.println(maxProfit);
		print(weight, profit, knapsackMaxWeight);
	}

	private static int maximizeProfit(int[] weight, int[] profit, int knapsackMaxWeight) {
		temp=new int[weight.length+1][knapsackMaxWeight+1];

		for(int i=0;i<=weight.length;i++){
			for(int w=0; w<=knapsackMaxWeight;w++){
				
				if(i==0 || w==0)
					continue;
				
				if(weight[i-1]<=w){
					temp[i][w]=Math.max(profit[i-1]+temp[i-1][w-weight[i-1]], temp[i-1][w]);
				} else {
					temp[i][w]=temp[i-1][w];
				}
			}
			
		}
		return temp[weight.length][knapsackMaxWeight];
	}
	
	private static void print(int wt[], int val[], int max){
		int res = temp[wt.length][max];
		int w = max;
		
		for(int i=wt.length; i>0 && res>=0 ;i--){
			if(res == temp[i-1][w])
				continue;
			else{
				System.out.println("Taken Wt : "+wt[i-1]);
				w = w-wt[i-1];
				res = res - val[i-1];
			}
		}
		
		
		
	}
}