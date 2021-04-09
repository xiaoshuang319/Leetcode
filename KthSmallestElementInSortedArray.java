class Solution {
    private class Coordinator{
        int xCoordinator;
        int yCoordinator;
        int value;
        public Coordinator(int xCoordinator, int yCoordinator, int value){
            this.xCoordinator = xCoordinator;
            this.yCoordinator = yCoordinator;
            this.value = value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        PriorityQueue<Coordinator>pq = new PriorityQueue<Coordinator>(((o1, o2) -> o1.value - o2.value));
        boolean[][]visit = new boolean[rowLen][colLen];
        pq.offer(new Coordinator(0,0,matrix[0][0]));
        visit[0][0] = true;
        for(int i = 0; i < k - 1; i++){
            Coordinator curr = pq.poll();
            int nextxCoordinator = curr.xCoordinator + 1;
            int nextyCoordinator = curr.yCoordinator + 1;
            if(nextxCoordinator < rowLen && !visit[nextxCoordinator][curr.yCoordinator]){
            
                pq.add(new Coordinator(nextxCoordinator,curr.yCoordinator, matrix[nextxCoordinator][curr.yCoordinator]));
                visit[nextxCoordinator][curr.yCoordinator] = true;
            }
            if(nextyCoordinator < colLen && !visit[curr.xCoordinator][nextyCoordinator]){
                pq.add(new Coordinator(curr.xCoordinator,nextyCoordinator,matrix[curr.xCoordinator][nextyCoordinator]));
              
                visit[curr.xCoordinator][nextyCoordinator]= true;
            }
        }
        return pq.peek().value;   
    }

}
