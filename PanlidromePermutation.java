//能不能form一个panlindrome
class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character>contain = new HashSet<>();
        for(char c : s.toCharArray()){
            if(contain.contains(c)){
                contain.remove(c);
            }else{
                  contain.add(c);   
            }
        }
        return contain.size() == 1 || contain.size() == 0;
    }
}
//method2
//我们只关注对于odd个数的元素的个数是不是一
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[]marker = new int[26];
        for(char c : s.toCharArray()){
            marker[c - 'a']++;
        }
        boolean oddApper = false;
        for(int ele : marker){
            if(ele % 2 == 1){
                if(oddApper){
                    return false;
                }
                oddApper = true;
            }
        }
        return true;
    }
}
