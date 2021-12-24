package arrays;


import java.util.ArrayList;

public class StockBuySell {


    public static void main(String[] args)    {
        // stock prices on consecutive days
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        System.out.print(maxProfit(prices));
    }

    // https://www.youtube.com/watch?v=eMSfBgbiEjk
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int cost = 0;
        int maxProfit = 0;

        if (n == 0) {
            return 0;
        }

        // store the first element of array in a variable

        int min_price = prices[0];

        for (int i = 0; i < n; i++) {

            // now compare first element with all the
            // element of array and find the minimum element
            min_price = Math.min(min_price, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min_price);
        }
        return maxProfit;
    }



    class Interval {
        int buy, sell;
    }

    // For anyNumber of Times Buy sell
    void stockBuySell(int price[], int n)
    {
        // Prices must be given for at least two days
        if (n == 1)
            return;

        int count = 0;
        // solution array
        ArrayList<Interval> sol = new ArrayList<Interval>();
        // Traverse through given price array
        int i = 0;
        while (i < n - 1) {
            // Find Local Minima. Note that the limit is (n-2) as we are
            // comparing present element to the next element.
            while ((i < n - 1) && (price[i + 1] <= price[i]))
                i++;
            // If we reached the end, break as no further solution possible
            if (i == n - 1)
                break;
            Interval e = new Interval();
            e.buy = i++;
            // Store the index of minima
            // Find Local Maxima.  Note that the limit is (n-1) as we are
            // comparing to previous element
            while ((i < n) && (price[i] >= price[i - 1]))
                i++;

            // Store the index of maxima
            e.sell = i - 1;
            sol.add(e);
            // Increment number of buy/sell
            count++;
        }
        // print solution
        if (count == 0)
            System.out.println("There is no day when buying the stock "
                    + "will make profit");
        else
            for (int j = 0; j < count; j++)
                System.out.println("Buy on day: " + sol.get(j).buy
                        + "        "
                        + "Sell on day : " + sol.get(j).sell);
        return;
    }


    public int maxProfitSellAnyNumberOfTimes(int[] prices) {
        int maxProfit = 0;

        if(prices.length<=1)
            return 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]>prices[i-1]){
                maxProfit += prices[i]-prices[i-1];
            }
        }

        return maxProfit;
    }


}
