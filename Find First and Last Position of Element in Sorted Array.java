//case1: target in nums
//case2: target not in nums but there is element in array <= target or >= target
//case3: [1] 0, 
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int first = getFirst(nums,target);
        int last = getLast(nums,target);
        return new int[]{first,last};
    }
    //find the last element <= target
    private int getLast(int[]nums, int target){
        int start = 0, end = nums.length - 1, pos = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] <= target){
                pos = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return pos == - 1 ? - 1 : nums[pos] == target ? pos : -1;
        
    }
    //find the first element >= target
    private int getFirst(int[]nums, int target){
        int start = 0, end = nums.length - 1, pos = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] >= target){
                pos = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return pos == - 1 ? - 1 : nums[pos] == target ? pos : -1;
    }
}
