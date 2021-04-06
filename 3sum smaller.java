class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0; i < len; i++){
            int start = i + 1, end = len - 1;
            while(start + 1 <= end){
                int result = nums[i] + nums[start] + nums[end];
                if(result < target){
                    cnt += (end - 1) - (start + 1) + 1 + 1;
                    start++;
                }else{
                    end--;
                }
            }
        }
        return cnt;
    }
}
