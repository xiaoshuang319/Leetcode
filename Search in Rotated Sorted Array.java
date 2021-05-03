
//exit conidtion of binaryserach 
//case1: start + 1 < end :当target可以去到mid，但update start = mid（end = mid） 结束while循环后需要check一下start和end的元素
//case2: start < end: 当target取不到mid，但update start = mid（end = mid - 1） 
//case3: start <= end, 当target取不到mid，但update start = mid - 1（end = mid + 1）
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }
            if(nums[mid] <= nums[end]){
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                } 
            }
        }
        if(nums[start] == target)return start;
        if(nums[end] == target)return end;
        return -1;
    }
}
//Search in Rotated Sorted Array II

class Solution {
  public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] < nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                } 
            }else if(nums[mid] == nums[start]){ //move start untill nums[mid] !=nums[start] to help us know the increasing or decreasing 
                start++;
            }else if(nums[mid] == nums[end]){
                end--;
            }
        }
        if(nums[start] == target)return true;
        if(nums[end] == target)return true;
        return false;
    }
}
