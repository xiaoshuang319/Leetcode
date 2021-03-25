class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
       Map<Integer,Integer>moduletoIndex = new HashMap<>();
        moduletoIndex.put(0,-1);
        int preSum = 0;
        int mod = 0;
        for(int i = 0; i < nums.length; i++){
            preSum += nums[i];
            if(k != 0){
                mod = preSum % k;
            }
           if(k == 0){
                mod = preSum;
            }
            if(moduletoIndex.containsKey(mod)){
                if(i - moduletoIndex.get(mod) > 1){
                    return true;
                }
            }else{
                moduletoIndex.put(mod,i);
            }
        }
        return false;
    }
}
