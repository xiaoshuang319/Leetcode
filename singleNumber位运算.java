class Solution {
    //a^0 = a
    //a ^ a = 0
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
