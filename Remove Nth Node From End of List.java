class Solution {
  //method1
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalLen = helper(head);
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;
        ListNode curr = head;
        int count = 0;
  
        while(curr != null && count <  totalLen  - n){
            pre.next = curr;
            curr = curr.next;
            pre = pre.next;
            count++;  
        }
        pre.next = curr.next;
        curr.next = null;
        return dummyNode.next;
        
    }
    private int helper(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
//method2:
//slow, fast
//First, the fast node move to position n(正数数的位置） and slow node will begin at position 0;
//so the distance between node fast and slow will always be n;
//当fast move到null的位置的时候， slow 则是在要删除元素的位置，为了知道preNode，所以当fast。next停留在null的时候slow则停留在删除元素的prev。

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }
      //删除的元素是head。
        if(fast == null)return head.next;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
