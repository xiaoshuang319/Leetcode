class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int res = 0;
        for(int i = nums.length - 1; i >= 0 && count <= k - 1; i--){
            res = nums[i];
            count++;
        }
        return res;
    }
}
