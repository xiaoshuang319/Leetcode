class Solution {
    public int[] sortedSquares(int[] nums) {
      int len = nums.length;
      int[]res = new int[len];
       for(int i = 0; i < len; i++){
           res[i] = (int) (Math.pow(nums[i],2));
       }
       Arrays.sort(res);
       return res;
    }
}
