class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length; 
        List<List<Integer>>result = new ArrayList<>();
        for(int i = 0; i + 2 <= len; i++){
            int target = 0 - nums[i];
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            List<List<Integer>>temp = new ArrayList<>();
            helper(temp,nums,target,i + 1, len);
            if(temp.size() != 0){
                for(List<Integer>ele : temp){
                   ele.add(0, nums[i]);   
                }
                result.addAll(temp);
            }
        }
        return result;
    }
    private void helper(List<List<Integer>>result,int[]nums, int target, int start, int len){
        int end = len - 1;
        while(start + 1 <= end){
            if(nums[start] + nums[end] == target){
                List<Integer>twoSum = new ArrayList<>();
                twoSum.add(nums[start]);
                twoSum.add(nums[end]);
                result.add(twoSum);
                //只能判断当前和下一个，因为最后start也要在加一次
                //终止条件是nums[start] ！= nums[start + 1] 但还是等于nums[start - 1]
                while(start + 1 < len && nums[start] == nums[start + 1]){
                    start++;
                }
                while(end > 0 && nums[end] == nums[end  - 1]){
                    end--;
                }
                start++;
                end--;
            }else if(nums[start] + nums[end] < target){
                start++;
            }else{
                end--;
            }
        }
    }
}
// [-4,-1,-1,0,1,2]
// nums[i] = -1,
