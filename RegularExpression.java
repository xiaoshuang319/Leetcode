class Solution {
    //套路：
    //尽量把dp[i][j]往 1) dp[i-1][j] 2)dp[i][j - 1] 3)dp[i-1][j-1]靠
    public boolean isMatch(String s, String p) {
        String copyS= "#" + s, copyP = "#" + p;
        int n = copyS.length(), m = copyP.length();
        boolean[][]dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        //dp[0][j] Y*Y*Y*
        for(int j = 2; j < m ; j++){
            dp[0][j] = copyP.charAt(j) == '*' && dp[0][j-2];
        }
         for(int i = 1; i < n; i++){
             for(int j = 1; j < m; j++){
                    //case1:p[i]is characterer, s[i] == p[i] => dp[i][j] = dp[i-1][j-1]
                 if(Character.isAlphabetic(copyP.charAt(j))){
                     dp[i][j] = copyS.charAt(i) == copyP.charAt(j) && dp[i-1][j-1];
                 }else if(copyP.charAt(j) == '.'){
                    //case2:p[i] is ., dp[i][j] = dp[i-1][j-1]
                      dp[i][j] = dp[i-1][j-1];
                 }else if(copyP.charAt(j) == '*'){
                //case3: 1)p[i] is '*',  if(s[i] == p[j - 1] || p[j-1] == '.' ) && dp[i-1][j];//2) dp[i][j] = dp[i][j-2]
                     boolean possible1 = dp[i][j-2];
                     boolean possible2 = (copyS.charAt(i) == copyP.charAt(j - 1) || copyP.charAt(j - 1) == '.') && dp[i-1][j];
                     dp[i][j] = possible1 || possible2;
                 }
             }
         }   
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.println(i +"---->" + j  + "--->" + dp[i][j]);
        //     }
        // }
        return dp[n-1][m-1];           
    }
}
