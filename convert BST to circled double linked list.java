class Solution {
    Node pre = null;
    public Node treeToDoublyList(Node root) {
      if(root == null)return null;
      Node dummyNode = new Node(0,null,null);
      pre = dummyNode;
      helper(root);
      dummyNode.right.left = pre;
      pre.right = dummyNode.right;
      return dummyNode.right;
    }
    private void helper(Node node){
        if(node == null)return;
        helper(node.left);
        pre.right = node;
        node.left = pre;
        pre = node;
        helper(node.right);
        
    }
}
