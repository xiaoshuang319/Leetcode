class Solution {
    public int shortestDistance(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;
        int[][]numLevels = new int[rowLen][colLen];
        int[][]numReach = new int[rowLen][colLen];

        int distance = Integer.MAX_VALUE;
        int countBuilding = 0;
        int[][]dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        //step1:find the number of level each building can reach for zero 
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 1){
                    bfs(grid,numLevels,numReach,i,j,rowLen,colLen,dir);
                    countBuilding++;
                }
            }
        }
        //step2: among all zeros all building can reach to, find the mininum
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(grid[i][j] == 0 && numReach[i][j] == countBuilding){
                    //System.out.println(numLevels[i][j]);
                    distance = Math.min(numLevels[i][j],distance);
                }
            }
        }
        return distance == Integer.MAX_VALUE ? -1 : distance;
    }
    private void bfs(int[][]grid, int[][] numLevels, int[][]numReach, int x, int y,  int rowLen, int colLen,int[][]dir){
        Queue<int[]>queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        boolean[][]visit = new boolean[rowLen][colLen];  
        visit[x][y] = true;
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[]curr = queue.poll(); 
                for(int[] ele : dir){
                    int nextX = curr[0] + ele[0];
                    int nextY = curr[1] + ele[1];
                    if(nextX >= rowLen || nextX < 0 || nextY >= colLen || nextY < 0 || grid[nextX][nextY] != 0 || visit[nextX][nextY]){
                        continue;
                    }
                    visit[nextX][nextY] = true;
                    numLevels[nextX][nextY] += level;
                    numReach[nextX][nextY]++;
                    queue.add(new int[]{nextX, nextY});
                }
            }
            level++;   
        } 
    }
}
