class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer>mapToFreq = new HashMap<>();
        
        for(char c : t.toCharArray()){
           mapToFreq.put(c,mapToFreq.getOrDefault(c,0) + 1); 
        }
        int totalNeededMatchedChar = mapToFreq.size();
        int start = 0, end = 0, marker = 0, len = s.length(), substringLen = Integer.MAX_VALUE;
        while(end < len){
            char currCharacter = s.charAt(end);
            if(mapToFreq.containsKey(currCharacter)){
                mapToFreq.put(currCharacter,mapToFreq.get(currCharacter) - 1);
                if(mapToFreq.get(currCharacter) == 0){
                    totalNeededMatchedChar--;
                }
            }
            end++;
            while(totalNeededMatchedChar == 0){
                if(substringLen > end - start){
                    substringLen = end - start;
                    marker = start;
                }
                char toBeDeletedChar = s.charAt(start);
                if(mapToFreq.containsKey(toBeDeletedChar)){
                    mapToFreq.put(toBeDeletedChar,mapToFreq.get(toBeDeletedChar)+1);
                    if(mapToFreq.get(toBeDeletedChar) > 0){
                         totalNeededMatchedChar++;
                    }
                }
                start++;
            }
         
        }
        return substringLen == Integer.MAX_VALUE ? "" : s.substring(marker, marker + substringLen);  
    }
}
