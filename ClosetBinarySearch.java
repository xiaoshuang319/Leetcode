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
class Solution {
    public int closestValue(TreeNode root, double target) {
        long[] res = new long[1];
        res[0] = Long.MAX_VALUE;
        helper(root,target,res);
        return (int)(res[0]);
    }
    private void helper(TreeNode root,double target, long[] res ){
        if(root == null)return;
        if(Math.abs(res[0] - target)  > Math.abs(root.val -target) ){
            res[0] = root.val;
        }
        if(root.val > target){
        helper(root.left,target,res);
        }
        if(root.val < target){
        helper(root.right, target,res);
        }
        
    }
}
