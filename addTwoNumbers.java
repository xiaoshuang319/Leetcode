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
//342
//465
 //  8 0 7
