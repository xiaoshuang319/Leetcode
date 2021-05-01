class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer,Integer>sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0, result = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sumToIndex.containsKey(sum - k)){
                //System.out.println(i + "--->" + (sum - k) +"--->" +  sumToIndex.get(sum - k));
                result = Math.max(result,i - sumToIndex.get(sum - k)); 
            }
            if(!sumToIndex.containsKey(sum)){ //相同的sum出现早的
                   sumToIndex.put(sum,i);
            }
         
        }
        return result;
    }
}
