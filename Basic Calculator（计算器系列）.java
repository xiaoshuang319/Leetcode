//basic caculator  I
//sign: tell the current digit it is negative or positive
//result: accumulateive sum
//case1: not (, when i meet digit, keep adding digit*sign to result
//case2: (, need to writed down sign, result and reset sign, result for cacualtion inside.
//case3: ), current result means all reust insedie parentehese, 
class Solution {
    public int calculate(String s) {
       int len = s.length();
        int result = 0;
        int previousSign = 1;
        Stack<Integer>stack = new Stack<>();
        for(int i = 0; i < len; i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
               int digit = curr - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))){
                    digit = digit * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result = result + (digit * previousSign);  
            }else if(!Character.isDigit(curr) && curr != ' '){
                if(curr == '+'){
                    previousSign = 1;
                }else if(curr == '-'){
                    previousSign = -1;
                }else if(curr == '('){
                    stack.push(result);
                    stack.push(previousSign);
                    result = 0;
                    previousSign = 1;
                }else if(curr == ')'){   
                    result = result * stack.pop() + stack.pop();
                }
            }
        }
        return result;
    }
}

//basic caculator  II
//method1:using stack
//two steps
//step1：extract number from string
//step2: perform caculation in order. order is defined as when  meet new signal, we need to caculate the result based on previous signal 
class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<>();
        int len = s.length();
        char previousSignal = '+';
        int currNum = 0;
        for(int i = 0; i < len; i++){
            char currCharacter = s.charAt(i);
            if(Character.isDigit(currCharacter)){
               currNum = currCharacter - '0';
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))){
                    currNum = currNum * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
       
            }

            if(!Character.isDigit(currCharacter) && currCharacter != ' ' || i == len - 1){
                if(previousSignal == '+')stack.push(currNum);
                if(previousSignal == '-')stack.push(-currNum);
                if(previousSignal == '*')stack.push(stack.pop() * currNum);
                if(previousSignal == '/')stack.push(stack.pop() / currNum);
                currNum = 0;
                previousSignal = currCharacter;
            }
        }
        int res = 0;
        for(int ele : stack){
          res += ele;
        }
        return res;
    }
}
//without using stack
//two steps
//step1：extract number from string
//step2: perform caculation in order. order is defined as when  meet new digit, we need to caculate the result based on previous signal, 
//update previos num, preivous accumulated sum

class Solution {
    public int calculate(String s) {
        int accumulatedSum = 0;
        int preNum = 0;
        char signal = '+';

        
        for(int i = 0; i < s.length(); i++){
            int currValInDigit = 0;
            char currVal = s.charAt(i);
            if(currVal == ' '){
                continue;
            }
            if(Character.isDigit(currVal)){
                currValInDigit = currVal - '0';
                while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    currValInDigit = currValInDigit * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if(signal == '+'){
                    accumulatedSum += preNum;
                    preNum = currValInDigit;
                }else if(signal == '-'){
                    accumulatedSum += preNum;
                    preNum = -currValInDigit;
                }else if(signal == '*'){
                    preNum = currValInDigit * preNum;
                   
                }else{
                     preNum = preNum /  currValInDigit;
                }
                
            }else{
                signal = currVal;
            }
         
        }
        return accumulatedSum + preNum;
    }
}
//basic caculator 
class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<>();
        char signal = '+';
        int result = 0;
        int len = s.length();
        int digit = 0;
        for(int i = 0; i < len; i++){
            char currCharacter = s.charAt(i);
            if(Character.isDigit(currCharacter)){
                digit = currCharacter - '0';
                System.out.println(digit);
                while(i + 1 < len && Character.isDigit(s.charAt(i + 1))){
                    digit = digit * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
            }
            if(currCharacter == '('){
                int leftCount = 1;
                int j = i + 1;
                while(leftCount > 0 ){
                    char curr = s.charAt(j);
                    if(curr == '('){
                        leftCount++;
                    }else if(curr == ')'){
                        leftCount--;
                    }
                    j++;
                }
                String temp = s.substring(i + 1, j);
                digit = calculate(temp);
                i = j - 1;
            }
            if((currCharacter != ' ' && !Character.isDigit(currCharacter)) || i == len - 1){
                 // System.out.println(digit);
                if(signal == '+'){
                 
                    stack.push(digit);
                }
                if(signal == '-'){
                    stack.push(-digit);
                }
                signal = currCharacter;
                digit = 0;
            }
        }
       
        while(!stack.isEmpty()){
             result += stack.pop();
        }
        return result;
    }
}
//basic caculator  III
