//method1: using stack, 
class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character>left = new Stack<>();
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            char curr = S.charAt(i);
            if(curr == '('){
                left.add(curr);
            }else{
                if(!left.isEmpty()){
                    left.pop();
                }else{
                   count++; 
                }
            }
        }
        while(!left.isEmpty()){
            count++;
            left.pop();
        }
        return count;
    }
}

//method2: without using stack, precaculated the neededleft parenthesis, right parentheis
class Solution {
    public int minAddToMakeValid(String S) {
        int leftOpenParenthesis = 0, rightOpenParenthesis = 0;
        for(int i = 0; i < S.length(); i++){
            char curr = S.charAt(i);
            //case1: curr == '(', need to increase  rightOpenParenthesis
            if(curr == '('){
              rightOpenParenthesis++;  
            }else if(rightOpenParenthesis > 0){ //case2: curr == ')' but rightOpenParenthesis already increased, now decreasee
                rightOpenParenthesis--;
            }else{//case3:curr = ')' but never meet )m before
                leftOpenParenthesis++;
            }
        }
        return rightOpenParenthesis  + leftOpenParenthesis;
    }
}

//minAddToMakeValid
class Solution {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int open = 0, close = 0;
        //record the total close needs to be matched.
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                close++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '('){ 
                open++;
                if(close > 0){
                    close--;//one close is matched. 
                    result.append(curr);
                }
            }else if(curr == ')'){
                if(open > 0){
                    open--; //one open is matched.
                    result.append(curr);
                }else{
                    close--; //no open could be matched.
                }
            }else{
                result.append(curr);
            }
        }
        return result.toString();
    }
}
