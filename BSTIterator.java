/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Queue<Integer>input = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        traverse(root);
    }
    
    public int next() {
        return input.poll();
    }
    
    public boolean hasNext() {
        return input.size() != 0;
    }
    private void traverse(TreeNode root){
        if(root == null)return;
         traverse(root.left);
         input.add(root.val);
         traverse(root.right);
         
    }
}
