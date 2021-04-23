class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        boolean metNull = false;
        while(queue.peek() != null){
            TreeNode curr = queue.poll();
            queue.add(curr.left);
            queue.add(curr.right);
        }
        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}
