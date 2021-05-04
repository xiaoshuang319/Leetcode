class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for(int i = 0; i <len; i++){
            int start = i + 1, end = len - 1;
            while(start < end){
                int tempSum = nums[i] + nums[start] + nums[end];
                if(Math.abs(tempSum - target) <= Math.abs(sum - target)){
                    sum = tempSum;
                }
                if(tempSum == target){
                    return target;
                }else if(tempSum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return sum;
        
    }
}
