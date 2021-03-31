class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charToFreq = new int[26];
        for(char c : tasks){
            charToFreq[c - 'A']++;
        }
        int maxFreq = 0;
        int counter = 0;
        for(int ele : charToFreq){
            maxFreq = Math.max(ele,maxFreq);
          
        }
        for(int ele : charToFreq){
            if(ele == maxFreq){
                counter++;
            }
          
        }
        int groups = maxFreq - 1;
        int slots = n + 1;
    
        return Math.max(groups*slots+counter,tasks.length);
       
    }
}

// ABC ABC  AB
