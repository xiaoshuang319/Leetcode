class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String>result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            result.add(formRange(lower,upper));
            return result;
        }
        //first step: compare first ele with lower
        if(nums[0] > lower){
            result.add(formRange(lower, nums[0] - 1));
        }
        //second step: compare ele within the nums
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] + 1 != nums[i] && nums[i] > nums[i - 1] + 1){
                result.add(formRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        //thid step: compare ele with upper
        if(upper > nums[nums.length - 1]){
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        
        return result;
    }
    private String formRange(int start, int end){
        return start == end ? String.valueOf(start) : String.valueOf(start) + "->" + String.valueOf(end); 
    }
}
