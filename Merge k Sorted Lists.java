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
//method1: priorityqueue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>pq = new PriorityQueue<ListNode>(new CustomizedComparator());
      
        for(ListNode ele : lists){
            if(ele != null){
              pq.add(ele); 
            }
      
        }
        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;
     
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            if(curr.next != null){
                pq.add(curr.next);
            }
            temp.next = curr;
            temp = curr;
        }
        return dummyNode.next;
        
    }
    
    private class CustomizedComparator implements Comparator<ListNode>{
        public int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    }
}
//method2: mergeList
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null)return null;
        int size = lists.length();
        if(size == 1)return lists[0];
        int mid = size / 2;
        ListNode left = mergeKLists(lists.get(0),lists.get(mid));
        ListNode right = mergeKLists(lists.get(mid + 1),lists.get(size - 1));
        return mergetTwoLists(left, right);
        
    }
    private ListNode mergetTwoLists(ListNode a, ListNode b){
         if(a == null){
             return b;
         }
        if(b == null){
            return a;
        }
        if(a.val > b.val){
            b.next =  mergetTwoLists(a, b.next);
            return b;
        }else{
             a.next = mergetTwoLists(a.next,b);
            return a;
        } 
    }
}
//类似题
//Sort List

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
//和method2 的mergeKLists一样
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head, slow = head, pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        return mergerList(first,second);
    }
   // only work for each sorted linked list 
    private ListNode mergerList(ListNode l1, ListNode l2){
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        if(l1.val < l2.val){
            l1.next = mergerList(l1.next, l2);
            return l1;
        }else{
             l2.next = mergerList(l1,l2.next);
            return l2;
        }
    }
}
