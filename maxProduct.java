class Solution {
    public int maxProduct(int[] nums) {
       //result:  1. currentMax * currElem 2. currMin * currEle 3. currELe;
        int len = nums.length;
        int result = nums[0], min = nums[0], max = nums[0];
        for(int i = 1; i < len; i++){
            int temp = max;
            max = Math.max(nums[i], Math.max(max*nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min *nums[i] ));
            if(max > result){
                result = max;
            }
        }
        return result;
    }
}
