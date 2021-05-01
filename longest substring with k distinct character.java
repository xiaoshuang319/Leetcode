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
//04/21/2020
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        int[]freq = new int[256];
        int count = 0;
        int start = 0, end = 0, result = 0;
        while(end < len){
            char curr = s.charAt(end);
            if(freq[(int)(curr)] == 0){
                count++;
            }
            freq[(int)(curr)]++;
            while(start < len && count > k){
                char deletedCurr = s.charAt(start);
                freq[(int)(deletedCurr)]--;
                if(freq[(int)(deletedCurr)] == 0){
                    count--;
                }
                start++;
            }
             end++;
            result = Math.max(result, end - start);
           
        }
        return result;
    }
}
//一摸一样
// Max Consecutive Ones III

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, len = nums.length, zeroCount = 0, result = 0;
        for(int right = 0; right < len; right++){
            zeroCount += nums[right] == 0 ? 1 : 0;
            while(zeroCount > k){
                zeroCount -= nums[left] == 0 ? 1 : 0;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
