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
//对于一个node是valideBST
//node的左边是valid && 右边也是valid， 那么这个node就是valid
//valid 的条件是：可以构造一个min， max使得当前node在min 和max之间
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        return helper(root.left,Long.MIN_VALUE, root.val) && helper(root.right,root.val, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode node, long minValue, long maxValue ){
        if(node == null) return true;
        if(node.val <= minValue || node.val >= maxValue)return false;
        boolean leftBST = helper(node.left, minValue, node.val);
        boolean rightBST = helper(node.right, node.val, maxValue);
        return leftBST && rightBST;
        
    }
}
