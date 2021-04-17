
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//remember array nees to be sorted.
        int len = nums.length;
        boolean[]visit = new boolean[len];
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        helper(path, result, nums, visit);
        return result;
    }
    private void helper(List<Integer>path,List<List<Integer>>result, int[]nums, boolean[]visit){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visit[i]){
                continue;
            }
            if(i - 1 >= 0 && nums[i] == nums[i - 1] && !visit[i - 1]){
                continue;
            }
            visit[i] = true;
            path.add(nums[i]);
            helper(path,result,nums,visit);
            visit[i] = false;
            path.remove(path.size() - 1);
        }
        
    }
}
