//method1
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String firstCharacter = strs[0];
        for(int i = 0;  i < firstCharacter.length(); i++){
            char curr = firstCharacter.charAt(i);
            for(int j = 1; j < strs.length; j++){
                if( i >= strs[j].length() ||  curr != strs[j].charAt(i)){
                    return firstCharacter.substring(0,i);
                }
            }
         
        }
        return firstCharacter;
    }
}

//method2
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){

            while(strs[i].indexOf(prefix) != 0){//直到找到以prefix卡开始的
                   
                    prefix = prefix.substring(0, prefix.length() - 1);
            }
            if(prefix.length() == 0){
                return "";
            }
        }
        
        return prefix;
        
    }
}
