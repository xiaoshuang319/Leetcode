//Anagram：string a 各个字母之间任意交换可以构成string b
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[]a = new int[256];
        int[]b = new int[256];
        int len = s.length();
        for(int i = 0; i < len; i++){
            a[s.charAt(i)]++;
            b[t.charAt(i)]++;
        }
        for(int i = 0;  i < 256; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
