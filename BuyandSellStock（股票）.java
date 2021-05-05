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
