class Solution {
    public int uniquePaths(int m, int n) {
        int[]dp = new int[m];
        for(int i = 0; i < m; i++){
            dp[i] = 1;
        }
       //先遍历col，在遍历row
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[j] = dp[j] + dp[j - 1];
                    //dp[j]:在同一行的上一列的相同位置的值， dp【j-1】表示在上一行的同一列
            }
        }
        
        return dp[m - 1];
    }
}
