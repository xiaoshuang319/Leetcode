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
