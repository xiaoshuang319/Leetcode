class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int[]charToFreq = new int[256];
        int left = 0;
        int count = 0;
        int result = 0;
        for(int right = 0; right < len; right++){
            char curr = s.charAt(right);
            if(charToFreq[curr] == 0){
                count++;
            }
            charToFreq[curr]++;
            while(left <= right && count > k){
                char deleteChar = s.charAt(left);
                int deleteTargetFreq = charToFreq[deleteChar];
                if(deleteTargetFreq == 1){
                    charToFreq[deleteChar]--;
                    count--;
                }else{
                     charToFreq[deleteChar]--;
                }
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
        
    }
}
