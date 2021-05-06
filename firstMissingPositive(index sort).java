class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            while( i + 1 != nums[i] && nums[i] - 1 >= 0 && nums[i] - 1 < len && nums[nums[i] - 1] != nums[i] ){
               swap(nums, i,nums[i] - 1);
                 
            }
        }
        for(int i = 0; i < len; i++){
            if(i != nums[i] - 1){
                return i + 1;
            }
        }

        return nums.length + 1;
    }
    private void swap(int[]nums,int index1, int index2 ){
        int temp = nums[index1];
        nums[index1]= nums[index2];
         nums[index2] = temp;
    }
    
}
//missing number
//一摸一样
class Solution {
    public int missingNumber(int[] nums) {
   
        for(int i = 0; i < nums.length; i++){
            while(i != nums[i] && nums[i] < nums.length && nums[nums[i]] != nums[i]){
                swap(nums,i, nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    private void swap(int[]nums, int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
