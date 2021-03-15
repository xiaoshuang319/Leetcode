class Solution {
    public String alienOrder(String[] words) {
     int[] indegree = new int[26];
     Map<Character,Set<Character>>graph = new HashMap<>();
     if(!buildGraph(words,graph,indegree)){
         return "";
     }
     return bfs(graph,indegree);
    }
    private boolean buildGraph(String[] words, Map<Character, Set<Character>>graph, int[] indegree){
        for(String word: words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
         for(int i = 1; i < words.length; i++){
             String first = words[i - 1];
             String second = words[i];
             int firstIndex = 0, secondIndex = 0;
             int firstLength = first.length(), secondLength = second.length();
             while(firstIndex < firstLength &&  secondIndex < secondLength){
                 char key = first.charAt(firstIndex);
                 char value = second.charAt(secondIndex);
                 if(key != value){
                     if(!graph.get(key).contains(value)){
                         graph.get(key).add(value);
                         indegree[value - 'a']++;
                     }
                     break;
                 }  
                 firstIndex++;
                 secondIndex++;
                 if(firstIndex < firstLength && secondIndex == secondLength){
                     return false;
                 }
             }
            
         }  
         return true; 
    }
    private String bfs(Map<Character, Set<Character>>graph, int[] indegree){
        Queue<Character>input = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(char c : graph.keySet()){
            if(indegree[c - 'a'] == 0){
                input.add(c);
                res.append(c);
            }
        }
        while(input.size() != 0){
            char curr = input.poll();
            for(char children : graph.get(curr)){
                indegree[children - 'a']--;
                if(indegree[children - 'a'] == 0){
                    res.append(children);
                    input.add(children);
                }
            }
        }
        return res.length() != graph.size() ? "" : res.toString();
    }
}
