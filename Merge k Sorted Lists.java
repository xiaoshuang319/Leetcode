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
