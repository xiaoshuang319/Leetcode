class Solution {
    public void wallsAndGates(int[][] rooms) {
        int rowLen = rooms.length, colLen = rooms[0].length;
        Queue<int[]>queue = new LinkedList<>();
        //add gate to the queue
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(rooms[i][j] == 0){
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][] dir = {{0,1},{0,-1}, {-1,0},{1,0}};
        while(!queue.isEmpty()){
            int[]currGate = queue.poll();
            int currRow = currGate[0];
            int currCol = currGate[1];
            for(int[] ele : dir){
                int nextRow = ele[0] + currRow;
                int nextCol = ele[1] + currCol;
                if(nextRow < 0 || nextRow >= rowLen || nextCol < 0 || nextCol >= colLen || rooms[nextRow][nextCol] != Integer.MAX_VALUE){ //rooms[nextRow][nextCol] != Integer.MAX_VALUE either wall or has reached
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[currRow][currCol] + 1;
                queue.add(new int[]{nextRow,nextCol});
            }
        }
    }
}
