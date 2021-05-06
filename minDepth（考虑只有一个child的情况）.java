class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        //只要任意一个left或者right为null，那么这里的minDepth 取决于另外一边
        //当两个child同时存在的话，取其中较小的一个
         return (left == 0 || right == 0) ? 1 + left + right: Math.min(left, right) + 1;
    }
}
