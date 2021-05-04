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
//一摸一样
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Map<Character,Integer>freq = new HashMap<>();
        boolean[]visited = new boolean[256];
        int start = 0;
        int result = 0;

        for(int end = 0; end < s.length(); end++){
            char curr = s.charAt(end);
            while(visited[curr]){//一旦当前charactrer被visit过那么，凡事以当前character结尾的全删除
                    char deletedChar = s.charAt(start);
                    visited[deletedChar] = false;
                    start++;
            } 
            visited[curr] = true;
            result = Math.max(result, end - start + 1);
          
        } 
      
      return result;
    }

}


//两个相同的数的距离是否 <= k
//其实就是相同的两个数是否出现在同一个window里。
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       //两个index之间的距离abs(i - j)
        Set<Integer>set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                set.remove(nums[i - k - 1]); //当windown size 对于k + 1的时候直接删除window头部的元素
            }
            if(!set.add(nums[i]))return true;
        }
        return false;
    }
}


// Contains Duplicate III
//其实就在同一个window里，比较最大的那个数（小于等于我的）和我之间的差值有没有可能小于等于t
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //两个index之间的距离abs(i - j)
        TreeSet<Long>set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k){
                set.remove((long)(nums[i - k - 1])); //当windown size 对于k + 1的时候直接删除window头部的元素
            } 
            long addElement = (long)(nums[i]);
            Long floorNumber = set.floor(addElement); //among all less or equal element, find the largest one
            Long ceilingNumber = set.ceiling(addElement); //among all greater or equal element, find the smallest one.
            if(floorNumber != null && (addElement- floorNumber) <= t)return true;
            if(ceilingNumber != null && (ceilingNumber - addElement) <= t)return true;
            set.add(addElement);
        }
        return false;
    }
}
