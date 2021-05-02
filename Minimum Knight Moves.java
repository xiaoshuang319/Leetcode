//method1: TLE

class Solution {
    //private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        int step = 0;
        Queue<int[]>queue = new LinkedList<>();
        Set<String>visit = new HashSet<>();
        queue.add(new int[]{0,0});
        visit.add("0,0");
        //up, down, left, right, left up diagnose, left down diagnose, right up diagnose, right down diagnose
        int[][]dir = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
      
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){ //遍历完当前所有的node
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                if(currX == x && currY == y){ 
                    return step;
                }
                for(int[]ele : dir){
                    int nextRow = currX + ele[0];
                    int nextCol = currY + ele[1];
                    String currVal = nextRow+","+nextCol;
                    if(!visit.contains(currVal)){
                        visit.add(currVal);
                        queue.add(new int[]{nextRow,nextCol});
                    }
                }
            }
            step++;
        }
        return -1;
    }
   
}
//method2:optimized.
class Solution {
    //private final int[][] DIRECTIONS = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    public int minKnightMoves(int x, int y) {
        int step = 0;
        Queue<int[]>queue = new LinkedList<>();
        Set<String>visit = new HashSet<>();
        queue.add(new int[]{0,0});
        visit.add("0,0");
      //The key idea is that the problem is symmetric in all 4 quadrants, so we can force all the target into first quadrants;
         x = Math.abs(x);
        y = Math.abs(y);
        //up, down, left, right, left up diagnose, left down diagnose, right up diagnose, right down diagnose
        int[][]dir = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
      
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int currX = curr[0];
                int currY = curr[1];
                if(currX == x && currY == y){
                    return step;
                }
                for(int[]ele : dir){
                    int nextRow = currX + ele[0];
                    int nextCol = currY + ele[1];
                    String currVal = nextRow+","+nextCol;
                  //nextRow >=- 1 && nextCol >= -1 handle from (0,0) to (1,1)
                    if(!visit.contains(currVal) && nextRow >= -1 && nextCol >= -1){
                        visit.add(currVal);
                        queue.add(new int[]{nextRow,nextCol});
                    }
                }
            }
            step++;
        }
        return -1;
    }
   
}
