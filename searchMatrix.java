//method1:对row进行binaysearch
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for(int[] ele : matrix){
            int start = 0, end = ele.length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(ele[mid] == target){
                    return true;
                }else if(ele[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
//method2:covert 2d to 1d
//start = 0, end = rowLen * colLen - 1
//mid(2d) = arr[mid（一维）/n][mid（一维 % n] 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        int start = 0, end = rowLen * colLen - 1; //covert 2d to 1d
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(matrix[mid / colLen][mid % colLen] == target){
                return true;
            }else if(matrix[mid / colLen][mid % colLen] < target ){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
