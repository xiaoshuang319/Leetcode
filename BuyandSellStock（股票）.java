//only one transaction
//buyPrice:记录截止到我的最小的value
class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MIN_VALUE;
        int profit = -1;
        for(int i = 0; i < prices.length; i++){
            buyPrice = Math.max(buyPrice, -prices[i]);
            profit = Math.max(profit,prices[i] + buyPrice );
        }
        return profit;
    }
}
//follow up 1
//method1: 
class Solution {
    public int maxProfit(int[] prices) {
       int profit = 0;
       for(int i = 0; i < prices.length; i++){//只要前一个比我小我就卖
         if(i - 1 >= 0 && prices[i] > prices[i - 1]){
             profit += prices[i] - prices[i - 1];
         }  
       }
        return profit;
    }
}
//method2:as many as transactions
class Solution {
    public int maxProfit(int[] prices) {
        int peak = prices[0];
        int valley = prices[0];
        int i = 0;
        int ans = 0;
        while (i < prices.length - 1) {
            //find valley value
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            //find peek value
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            ans += peak - valley;
        }
        return ans;
    }
}
//follow up 2: as many as transactions with fee
class Solution {
    public int maxProfit(int[] prices, int fee) {
        //sold:the maximum profit i have without stock
        //hold: the maximum profit i have with stock
        long sold = 0, hold = Long.MIN_VALUE;
        for(int i = 0; i < prices.length; i++){
            long hold1 = hold, sold1 = sold;
            hold = Math.max(hold1,sold1 - prices[i]); 
        
            sold = Math.max(sold1, hold1 + prices[i] - fee);
        }
        return (int)(sold);
    }
}
//follow up 3: at most 2 transactions
class Solution {
    //hold: maximum profit when hold stock
    //sold:maximum profit when sell the stock
   //第k天的第一次交易
    // hold1[k] = max(0 - p, hold1[k-1]);
    // sold1[k] = max(sold[k - 1], hold1[k] + p );
    //  //第k天的第二次交易
    //  hold2[k] = max(sold1[k] - p, hold1[k-1]);
    //  sold2[k] = max(hold2[k - 1] + p, sold2[k-1]);
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, sold1 = 0, hold2 = Integer.MIN_VALUE, sold2 = 0;
       for(int i = 0; i < prices.length; i++){
           int p = prices[i];
           int hold1_temp = hold1;
           int sold1_temp = sold1;
           int hold2_temp = hold2;
           int sold2_temp = sold2;
           hold1 = Math.max(0 - p, hold1_temp);
           sold1 = Math.max(hold1 + p, sold1_temp);
           hold2 = Math.max(sold1 - p, hold2_temp);
           sold2 = Math.max(hold2 + p, sold2_temp);
       } 
        return Math.max(sold1, sold2);
    }

    
}
