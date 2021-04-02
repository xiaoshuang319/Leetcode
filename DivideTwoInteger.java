class Solution {
    public int divide(int dividend, int divisor) {
        
       if(dividend == Integer.MIN_VALUE){
           if(divisor == -1){
               return Integer.MAX_VALUE;
           }
           if(divisor == 1){
               return Integer.MIN_VALUE;
           }
       }
        int res = 0;
        boolean isNegative = false;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            isNegative = true;
        }
        long ldividend = Math.abs((long)dividend);
  
         long ldivisor = Math.abs((long)divisor);
        while(ldividend >= ldivisor){
            int shift = 0;
            while(ldividend >= ldivisor<<shift){
                shift++;
            }
            res += 1<<(shift - 1);
            ldividend -= ldivisor<<(shift-1);
        }
        return isNegative ? (int)(~res+1) : res;
    }
}
