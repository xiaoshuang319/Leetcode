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



//similar method but different questions
//thought: find lowe bound, upper bound for subarray with len k .
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = findLastElementLessThanK(arr,x);
        System.out.println(left);
        int right =  findFirstElementGreaterThanK(arr,x);
         System.out.println(right);
        List<Integer>result = new ArrayList<>();
        while( k - (right - left - 1 ) > 0){
            if(left == -1){
              right++;
            }else if(right == arr.length){
              left--;
            }else if( x - arr[left] <= arr[right] - x){
                left--;
            }else{
              right++;
            }
        }
      for(int i = left + 1; i < right; i++){
        result.add(arr[i]);
      }
      return result;
    }
    private int findLastElementLessThanK(int[]arr,int x){
      int start = 0;
      int end = arr.length - 1;
      int pos = -1;
      while(start <= end){
        int mid = start + (end - start) / 2;
        int fMid = arr[mid];
        if(fMid < x){
          pos = mid;
          start = mid + 1;
        }else{
          end = mid - 1;
        }
      }
      return pos;
    }
    private int findFirstElementGreaterThanK(int[]arr,int x){
      int start = 0;
      int end = arr.length - 1;
      int pos = arr.length; // in case there no element greater than target, use pos = arr.length to differentia with no element less than K
      while(start <= end){
        int mid = start + (end - start) / 2;
        int fMid = arr[mid];
        if(x < fMid){
          pos = mid;
          end = mid - 1;
        }else{
          start = mid + 1;
        }
      }
      return pos;
    }
} //find the low bound of subarray with length k by comparing x - a[mid] with a[mid+k]-x
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
       
        int start = 0, end = arr.length - k; //the possible range of lowr bound
        while(start < end){
             int mid = start + (end - start) /2;
            if(x - arr[mid] > arr[mid + k] - x){ //A = [1,1,2,2,2,2,2,3,3], x = 3, k = 3
               start = mid + 1;
            }else{
               end = mid;
            }
        }
        List<Integer>result = new ArrayList<>();
        for(int i = start; i < start + k; i++){
            result.add(arr[i]);
        }
        return result;
    }
   
}


