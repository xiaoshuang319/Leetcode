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
