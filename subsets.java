class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        List<Integer>path = new ArrayList<>();
        helper(nums, 0, path,result);
        return result;
    }
    private void helper(int[]nums, int startIndex,List<Integer>path, List<List<Integer>>result){
        result.add(new ArrayList<>(path));//once enter the function, add path to result as path record previous.
        if(startIndex == nums.length){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
           path.add(nums[i]);
           helper(nums,i+1, path, result);
           path.remove(path.size() - 1);
        }
    }
}
