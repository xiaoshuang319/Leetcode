//time complexity:O(v + E)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]indegree = new int[numCourses];
        //adjacent list represent the graph
        List[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] ele : prerequisites){
            int pre = ele[0];
            int curr = ele[1];
            indegree[curr]++;
            graph[pre].add(curr);
        }
        Queue<Integer>queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
           if(indegree[i] == 0){
               queue.add(i);
               count++;
           } 
        }
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i = 0; i < graph[curr].size(); i++){
                int ele = (int)(graph[curr].get(i));
                indegree[ele]--;
                if(indegree[ele] == 0){
                    count++;
                    queue.add(ele);
                }
            }
        }
        return count == numCourses;
    }
}
