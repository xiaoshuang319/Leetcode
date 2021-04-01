class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer>taskToFreq = new HashMap<>();
        for(char c : tasks){
            taskToFreq.put(c, taskToFreq.getOrDefault(c,0) + 1);
        }
       PriorityQueue<Map.Entry<Character,Integer>>pq = new PriorityQueue<Map.Entry<Character,Integer>>(
            (a,b) -> (b.getValue() - a.getValue()));
        
        
        
        
        pq.addAll(taskToFreq.entrySet());
        int cycle = n + 1;
        int totalTime = 0;
        StringBuilder path = new StringBuilder();
        while(!pq.isEmpty()){
            List<Map.Entry<Character,Integer>>processedTasks = new ArrayList<>();
            int workTime = 0;
            for(int i = 0; i < cycle; i++){
                if(!pq.isEmpty()){
                    Map.Entry<Character,Integer> curr = pq.poll();
                    processedTasks.add(curr);
                    workTime++;
                    path.append(curr.getKey());
                }
            }
            for(Map.Entry<Character,Integer> ele : processedTasks){
                int freq = ele.getValue();
                freq = freq-1;
                if(freq != 0){
                    ele.setValue(freq);
                    pq.add(ele);
                }
            }
            totalTime += pq.isEmpty() ? workTime : cycle;
            while(workTime < cycle &&  !pq.isEmpty()){
                path.append('#');
                workTime++;
            }
        }
         System.out.println(path);
         return totalTime;
    }
   
}
