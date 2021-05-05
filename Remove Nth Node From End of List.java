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
//要知道target的previous
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode dummyNode = new ListNode(-1);
      dummyNode.next = head;
      ListNode pre = dummyNode;
      //find left target's previous
      for(int i = 1; i < left ; i++){
          pre = pre.next;
      }
      //left target
      ListNode curr = pre.next;
        //最简单的例子 1-〉2-〉3 -〉 4要交换2 和3
       for(int i = left; i < right; i++){
          ListNode next = curr.next;
          curr.next = next.next;
          next.next = pre.next;
          pre.next = next;  
       }
      return dummyNode.next;

    }
}//的previous
class Solution {
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
       if(root == null)return;
        flatten(root.right);
        flatten(root.left);
        //到我的话
        //我的右边应该point出上次flatten的root
        //我的左边是null
        root.right = pre;
        root.left = null;
        pre = root;
    }
