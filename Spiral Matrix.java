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
