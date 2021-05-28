class Solution {
    public void rotate(int[][] matrix) {
        int top = 0, bottom = matrix[0].length - 1;
        while(top < bottom){
            int[]temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }
      
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix[0].length; j++){ //只反转对角线的上半部分
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}


class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1); //rerver entire array
        reverse(nums,0,k - 1); //reverse subarray from 0 to k - 1,
        reverse(nums,k, len - 1);//reverse subarray from k to len - 1,
    }
    private void reverse(int[]nums, int start, int end){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
