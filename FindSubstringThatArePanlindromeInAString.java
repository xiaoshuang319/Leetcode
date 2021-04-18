import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        String input = "aabbaab";
        List<String>result = new ArrayList<>();
        int len = input.length();
        
      //  "a" "a" "a" "a" "b" "b" "b" "aa" "aa" "bb" "aabbaa" "baab" "abba".
        
        
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j <= len; j++){
                String temp = input.substring(i,j);
                //System.out.println(temp);
                if(isPalindrome(temp)){
                    result.add(temp);
                }
            }
        }
        for(String ele : result){
            System.out.println(ele);
        }
     }
     private static boolean isPalindrome(String input){
         int start = 0, end = input.length()-1;
         while(start + 1 <= end){
             if(input.charAt(start) != input.charAt(end)){
                 return false;
             }
             start++;
             end--;
         }
         return true;
     }
}
