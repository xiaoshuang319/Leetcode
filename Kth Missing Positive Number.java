class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        int pos = -1;
        //find the last element less than k
        while(low <= high){
            int mid = low + (high - low ) / 2;
            if(arr[mid] - (mid + 1) < k){
                low = mid + 1;
                pos = mid;
            }else{
                high = mid - 1;
            }
        }
        return pos + k + 1;
    }
}

