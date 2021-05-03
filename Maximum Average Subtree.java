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
    public double maximumAverageSubtree(TreeNode root) {
        return postorder(root).avg;
    }
    //postorder
    //左边的child的sum，count， avge
    //右边的child的sum，count，avg
    //我的话：sum:（左边的child的sum + 右边的child的sum）
    //       count: 左边的child的count + 右边的child的count
    //.       avg: sum / count;
    private Result postorder(TreeNode node){
        if(node == null){
            return new Result(0,0,0);
        }
        Result leftResult = postorder(node.left);
        Result rightResult = postorder(node.right);
        int sum = leftResult.sum + rightResult.sum + node.val;
        int count = leftResult.count + rightResult.count + 1;
        double avg = Math.max(sum * 1.0 / count,Math.max(leftResult.avg,rightResult.avg));
        return new Result(sum, count, avg);
        
        
    }
    private class Result{
        int sum;
        int count;
        double avg;
        public Result(int sum, int count, double avg){
            this.sum = sum;
            this.count = count;
            this.avg = avg;
        }
    }
}
