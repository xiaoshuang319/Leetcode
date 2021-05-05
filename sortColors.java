//partition的概念：
//1.zero永远指向0， two永远指向2
class Solution {
    public void sortColors(int[] nums) {
       int zero = -1, two = nums.length, i = 0;
        while(i < two){
            if(nums[i] == 1){
                i++;
            }else if(nums[i] == 0){
                zero++;
                swap(nums, i, zero);
                i++;
            }else if(nums[i] == 2){
                two--;
                swap(nums, i, two);
                
            }
        }
    }
    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
