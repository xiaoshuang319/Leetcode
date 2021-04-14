class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = m + n - 1;
        int nums1Index = m - 1;
        int nums2Index = n - 1;
        while(nums1Index >= 0 || nums2Index>= 0){
            if(nums1Index == -1 || (nums2Index>= 0 && nums2[nums2Index] >nums1[nums1Index])){
                nums1[idx] = nums2[nums2Index];
                nums2Index--;
            }else{
                nums1[idx] = nums1[nums1Index];
                nums1Index--;
            }
            idx--;
        }

        
    }
}
