class Solution {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[]visit = new int[len];
        for(int i = 0; i < len; i++){ //needs to iterating each graph as the graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
            if(visit[i] != 0){
                continue;
            }
            Queue<Integer>queue = new LinkedList<>();
            queue.add(i);
            visit[i] = 1;
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int nei : graph[curr]){
                    int colored = visit[curr] == 1 ? 2 : 1;
                    if(visit[nei] == 0){
                        visit[nei] = colored;
                        queue.add(nei);
                    }else{
                        if(colored != visit[nei]){
                            return false;
                        }
                    }
                }
            }            
        }

        return true;
    }
}
