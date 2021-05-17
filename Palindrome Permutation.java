class Solution {
    public boolean canPermutePalindrome(String s) {
        int[]freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        boolean odd = false;
        for(int ele : freq){
            if(ele % 2 != 0){
                if(odd){
                     return false;
                }
                odd = true;
            }
        }
        return true;
    }
}
