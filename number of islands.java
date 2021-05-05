class Solution {
    public int numIslands(char[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length, count = 0;
        Set<String>visited = new HashSet<>();
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == '1' && !visited.contains(i + "," + j)){
                   count++;
                   marker(grid,i,j,rowLen, colLen, visited);
                }
            }
        }
        return count;
    }
    private void marker(char[][]grid,int rowIndex, int colIndex,int rowLen, int colLen, Set<String>visited){
        //不meet illegal 的条件
        if(rowIndex < 0 || rowIndex >= rowLen || colIndex < 0 || colIndex >= colLen || visited.contains(rowIndex + "," + colIndex) || grid[rowIndex][colIndex] == '0'){
            return;
        }
        visited.add(rowIndex + "," + colIndex);
        //up
        marker(grid, rowIndex - 1, colIndex, rowLen, colLen, visited);
        //down
        marker(grid, rowIndex + 1, colIndex, rowLen, colLen,visited);
        //left
        marker(grid, rowIndex, colIndex - 1,rowLen, colLen, visited);
        //right
       marker(grid, rowIndex, colIndex + 1, rowLen, colLen,visited);
    }
}
//Word Search
class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rowLen = board.length, colLen = board[0].length;
        boolean[][]visited = new boolean[rowLen][colLen];
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(board[i][j] == word.charAt(0)){//遍历每个以grid开始的character
                    if(found(board, i, j, rowLen, colLen, visited,0,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean found(char[][]board, int rowIndex, int colIndex, int rowLen, int colLen, boolean[][]visited, int currIndex, String word){
        if(currIndex == word.length()){
            return true;
        }
        if(rowIndex >= rowLen || rowIndex < 0 || colIndex >= colLen || colIndex < 0 || board[rowIndex][colIndex] != word.charAt(currIndex) || visited[rowIndex][colIndex]){
            return false;
        }
        visited[rowIndex][colIndex] = true;
        if(
           found(board,rowIndex - 1, colIndex, rowLen, colLen, visited, currIndex + 1, word)  
            || found(board,rowIndex + 1, colIndex, rowLen, colLen, visited, currIndex + 1,word)  
           ||  found(board,rowIndex, colIndex - 1, rowLen, colLen, visited, currIndex + 1,word)  
           ||  found(board,rowIndex, colIndex + 1, rowLen, colLen, visited, currIndex + 1,word) 
        ){
            return true;
        }
      visited[rowIndex][colIndex] = false;
        return false;
    }
}
