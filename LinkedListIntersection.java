/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pNode = p;
        Node qNode = q;
        while(pNode != qNode){
            pNode = pNode == null ? q : pNode.parent;
            qNode = qNode == null ? p : qNode.parent;
        }
        return pNode;
    }
}
