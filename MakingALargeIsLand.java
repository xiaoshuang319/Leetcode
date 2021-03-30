class Solution {
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean zeroFlag = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int area = 0;
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    area = dfs(grid,i,j,new boolean[m][n],dir);
                    result = Math.max(area,result);
                    if(area == m * n){
                        return area;
                    }
                    grid[i][j] = 0;
                    zeroFlag = true;
                    
                }
            }
        }
        return zeroFlag ? result :m * n ;
    }
    private int dfs(int[][]grid, int row, int col, boolean[][]visit,int[][]dir){
        int area = 0;
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visit[row][col] || grid[row][col] == 0){
            return area;
        }
        visit[row][col] = true;
        for(int[] ele : dir){
            area += dfs(grid, row + ele[0], col + ele[1],visit,dir);
        }
        return 1 + area;
    }
}
