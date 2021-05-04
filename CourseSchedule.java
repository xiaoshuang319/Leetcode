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
//05/03/2021
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>preToNext = new HashMap<>();
        int[] indegree = new int[numCourses];
        //build graph + record indegree
        for(int[] course : prerequisites){
          if(preToNext.containsKey(course[1])){
              preToNext.get(course[1]).add(course[0]);
          }else{
        
              preToNext.put(course[1], new ArrayList<>());
              preToNext.get(course[1]).add(course[0]);
          }
          indegree[course[0]]++; 
       }
       int takeCourse = 0;
        //Get no prerequest course
        Queue<Integer>queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){//note：这里要用到numCourses而不能用map，因为map存的是有prerequest的。对于没有prerequest那么比如1 【】这个就适用了
            if(indegree[i] == 0)    
                queue.add(i);
                takeCourse++;
            }
        }
    
        //check followed course 
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                System.out.println(curr);
                if(preToNext.containsKey(curr)){
                    for(int ele : preToNext.get(curr)){
                        indegree[ele]--;
                        if(indegree[ele] == 0){
                            queue.add(ele);
                            takeCourse++;
                        }
                    }                    
                }

            }
        }
        return takeCourse == numCourses;
    }
}
//course schedule II 
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>>preToNext = new HashMap<>();
        int[] indegree = new int[numCourses];
        //build graph + record indegree
        for(int[] course : prerequisites){
          if(preToNext.containsKey(course[1])){
              preToNext.get(course[1]).add(course[0]);
          }else{
        
              preToNext.put(course[1], new ArrayList<>());
              preToNext.get(course[1]).add(course[0]);
          }
          indegree[course[0]]++; 
       }
       int[] result = new int[numCourses];
        int takeCourse = 0;
        int index = 0;
        //Get no prerequest course
        Queue<Integer>queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){//note：这里要用到numCourses而不能用map，因为map存的是有prerequest的。对于没有prerequest那么比如1 【】这个就适用了
            if(indegree[i] == 0){    
                queue.add(i);
                result[index] = i;
                index++;
                takeCourse++;
            }
        }
        //check followed course 
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.poll();
                if(preToNext.containsKey(curr)){
                    for(int ele : preToNext.get(curr)){
                        indegree[ele]--;
                        if(indegree[ele] == 0){
                            result[index] =ele;
                            index++;
                            queue.add(ele);
                            takeCourse++;    
                        }
                    }                    
                }
            }
        }
        return takeCourse != numCourses ? new int[]{} : result;
       
    }
}
