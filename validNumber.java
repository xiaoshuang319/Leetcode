class Solution {
    public boolean isNumber(String s) {
      int len = s.length();
      int index = 0;
      boolean isDigit = false;
     //Meet all the following criteria, then String is valid 
     //no white space in the begining, in the end
     while(index < len && Character.isWhitespace(s.charAt(index))){
          index++;
      }
      //When current character is +,make sure have digit behind and no more +/e before it
     while(index < len && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            index++;
            isDigit=false;
            if(index < len && (s.charAt(index) == '+' || s.charAt(index) == '-') ){
                break;
            }
      }
     while(index < len && Character.isDigit(s.charAt(index))){
          isDigit=true;
          index++;
      }
     //when current character is ., make sure have digit behind
    if(index < len && s.charAt(index) == '.' ){
        index++;
        while(index < len && Character.isDigit(s.charAt(index))){
            index++;
            isDigit = true;
        }
    }
    //when current character is e/E,make sure 1) has digit behind; 2)if count . break
    if(index < len && (s.charAt(index) == 'e' || s.charAt(index) == 'E') && isDigit){
        index++;
        isDigit = false;
        if(index < len && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            index++;
        }        
        while(index < len && Character.isDigit(s.charAt(index))){
            index++;
            isDigit = true;
        }
        
    }   
    while(index < len && Character.isWhitespace(s.charAt(index))){
          index++;
    }
        //if all the above cretirea meet, check whether we reach to the end of string and whethere we meet digit
     return index == len && isDigit;

        
    
    }
}
