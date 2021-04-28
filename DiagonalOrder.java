class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = matrix[r][c];
            if((r + c) % 2 == 0){
                //note:(0,0) (0,2)
                //needs to check col first.
                if(c == n - 1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }
             
            }else{
                if(c == 0){
                    r++;
                }else if(r == m - 1){
                    c++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return arr;
    }
}

