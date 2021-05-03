class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        helper(candidates, 0, target, 0, path, result);
        return result;
    }
    //backtracking 一路往下的操作，返回的操作
    private void helper(int[]candidates, int startIndex, int target, int sum, List<Integer>path, List<List<Integer>>result){
        if(target == sum){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            //提前砍支
            if(sum > target){
                break;
            }
            //一路往下的操作是sum += node.val， 同时加到array里
            sum += candidates[i];
            path.add(candidates[i]);
            //一路往上返回的操作是sum -= node.val, 同时从array里删除
            helper(candidates,i,target, sum, path, result);
            sum -= candidates[i];
            path.remove(path.size() - 1);
        }
        
    }
}
