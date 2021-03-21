class Solution {
    int[]weightSum;
    int len;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        weightSum = new int[len];
        len = w.length; 
        for(int i = 1; i < len; i++){
           w[i] = w[i] + w[i - 1];
       } 
        weightSum = w;
    }
    
    public int pickIndex() {
      int target = random.nextInt(weightSum[len - 1]) + 1;
      return binarySearch(weightSum,target);
    }
    private int binarySearch(int[]weightSum, int target){
        int start = 0, end = len - 1, pos = -1;
     
        while(start <= end){
           int mid = start + (end - start) / 2;
            if(weightSum[mid] <= target){
                start = mid + 1;
                pos = mid;
            }else{
                end = mid - 1;
            }
        }
        //case1 : no element <= target  => pos = 0
        //case2: the element pos point to < target => post + 1
        //case3: the element pos point = target =>pos
        return pos == -1 ? 0 : weightSum[pos] == target ? pos : pos + 1;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
