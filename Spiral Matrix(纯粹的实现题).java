class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //case1: colLen = rowLen
        //case2: rowLen > colLen(need to make sure that we  both col and row )
        //case3: rowLen < coLLen
        int rowLen = matrix.length, colLen = matrix[0].length;
      
        int rowStart = 0, rowEnd = rowLen - 1, colStart = 0, colEnd = colLen - 1;
        List<Integer>result = new ArrayList<>();
        //make sure that we  both col and row
        //通过移动上下左右四个pointer来缩小范围
        while(rowStart <= rowEnd &&  colStart <= colEnd){
            for(int col = colStart;  col <= colEnd; col++){
                result.add(matrix[rowStart][col]);
            }
            rowStart++; //finished one row
            
            for(int row = rowStart; row <= rowEnd; row++){
                result.add(matrix[row][colEnd]);
            }
            colEnd--; //finshed one col
            
            if(rowStart <= rowEnd){
                for(int col = colEnd;col >= colStart;col--){
                    result.add(matrix[rowEnd][col]);
                }
            }
            rowEnd--;
            
           if(colStart <= colEnd){
               for(int row = rowEnd;row >= rowStart; row--){
                   result.add(matrix[row][colStart]);
               }
           } 
          colStart++;
        }
        return result;
    }
}
//Spiral Matrix II
//填空
//Set Matrix Zeroes
class Solution {
    public void setZeroes(int[][] matrix) {
       //两个array记录需要变成0和1的index； 
        int rowLen = matrix.length, colLen = matrix[0].length;
        //利用matrix本身的第一行和第一列来store需要变成0和1的index从而节省空间。。。。
        boolean rowHasZero = false, colHasZero = false;
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(matrix[i][j] == 0){
                    if(i == 0)rowHasZero = true;
                    if(j == 0)colHasZero = true;
                  
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        
        
        //iterate 第一行
        for(int col = 1; col < colLen; col++){
            if(matrix[0][col] == 0){
                for(int row = 0; row < rowLen; row++){
                    matrix[row][col] = 0;
                }
            }
        }
       //iterate 第一列
        for(int row = 1;  row < rowLen; row++){
            if(matrix[row][0] == 0){
                for(int col = 0; col < colLen; col++){
                    matrix[row][col] = 0;
                }
            }
        }
        //判段第一行和第一列本省是否存在0
        if(rowHasZero){
            for(int col = 0; col < colLen; col++){
                matrix[0][col] = 0;
            }
        }
        if(colHasZero){
            for(int row = 0; row < rowLen; row++){
                matrix[row][0] = 0;
            }
        }
    }
}
