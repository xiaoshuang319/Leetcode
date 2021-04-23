class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                pre.next = curr.next;
            }else{
                   pre = pre.next;
            }
             curr = curr.next;
        }
        return dummyNode.next;
        
    }
}
