class Solution {
    public boolean isOneEditDistance(String s, String t) {
       
        //强制规定s为较短的
        //
        int sLen = s.length(), tLen = t.length();
        if(sLen > tLen){
            return isOneEditDistance(t, s);
        }
        for(int i = 0; i < sLen; i++){
            if(s.charAt(i) != t.charAt(i)){ //当前有一个元素不相等
                if(sLen == tLen){
                    return s.substring(i + 1).equals(t.substring(i + 1)); //repleace op 对于长度相等的
                }
                return s.substring(i).equals(t.substring(i + 1)); //对于长度不等的话， insert op
            }
        }
        
        return sLen == tLen - 1; //短的走完但是长的还没走完
    }
}
