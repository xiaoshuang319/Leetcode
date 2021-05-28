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
