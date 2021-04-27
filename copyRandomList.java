
class Solution {
    public Node copyRandomList(Node head) {
       Map<Node,Node>nodeToCopy = new HashMap<>();
       Node curr = head;
       while(curr != null){
           Node newNode = new Node(curr.val);
           nodeToCopy.put(curr, newNode);
           curr = curr.next;
       }
       curr = head;
        while(curr != null){
            Node newNode = nodeToCopy.get(curr);
            newNode.next = nodeToCopy.get(curr.next);
            newNode.random = nodeToCopy.get(curr.random);
            curr = curr.next;
        }
        return nodeToCopy.get(head);
    }
}
