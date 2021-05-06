/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode moving = dummyNode;
        int carry = 0;
        while(l1 != null || l2 != null){
            int l1Value = l1 == null ? 0 : l1.val;
            int l2Value = l2 == null ? 0 : l2.val;
            int currValue = l1Value + l2Value  + carry;
            if(currValue >= 10){
                carry = currValue / 10;
            }else{
                carry = 0;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null ) l2 = l2.next;
            moving.next = new ListNode(currValue % 10);
            moving = moving.next;
        }
        //corner case: 99, 9 
        if(carry == 1){
             moving.next = new ListNode(carry);
             moving = moving.next;
        }
        return dummyNode.next;
    }
}
//类似题：add two string
class Solution {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while(idx1 >= 0 || idx2 >= 0){
            int idx1Sum =  idx1 >= 0 ? num1.charAt(idx1) - '0' : 0;
            int idx2Sum = idx2 >= 0 ? num2.charAt(idx2) - '0' : 0;
            int currValue = idx1Sum + idx2Sum + carry;
            if(currValue >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            idx1--;
            idx2--;
            result.append(currValue % 10);
        }
        if(carry == 1){
             result.append(carry);
        }
        return result.reverse().toString();
    }
}
//类似题：Plus One
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        List<Integer>result = new ArrayList<>();
        int carry = 0;
      
        for(int i = len - 1; i >= 0; i--){
            int sum = (i == len - 1 ? digits[i] + 1 : digits[i]) + carry;
            if(sum >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            result.add(sum % 10);
        }
        if(carry == 1){
            result.add(carry);
        }
        int[]finalResult = new int[result.size()];
        int index = result.size() - 1;
        while(index >= 0){
            finalResult[index] = result.get( result.size() - 1 - index );
            index--;
        }
        return finalResult;
    }
}
