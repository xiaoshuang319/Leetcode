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
