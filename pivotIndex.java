class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
        int letfSum = 0, rightSum = sum;
        for(int i = 0; i < len; i++){
            rightSum = sum - letfSum - nums[i];
            if(rightSum == letfSum){
                return i;
            }
            letfSum += nums[i];
        }
        return -1;
    }
}
