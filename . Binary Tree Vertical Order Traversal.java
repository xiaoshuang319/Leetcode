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
    public List<List<Integer>> verticalOrder(TreeNode root) {
    if(root == null)return new ArrayList<>();
       int height = getDepth(root);
       int buckets = 2 * height - 1;
        int midIndex = height - 1;
       List<List<Integer>>result = new ArrayList<>();
       for(int i = 0; i < buckets; i++){
           result.add(new ArrayList<>());
       }
       Queue<Pair>queue = new LinkedList<>();
       queue.add(new Pair(root,midIndex));
      
       while(!queue.isEmpty()){
           int size = queue.size();
           for(int i = 0; i < size; i++){
                Pair node = queue.poll(); 
                TreeNode currNode = node.node;
                int yCoordinator = node.yCoordinator;
                result.get(yCoordinator).add(currNode.val);
               if(currNode.left != null){
                   queue.add(new Pair(currNode.left, yCoordinator - 1));
               }
                if(currNode.right != null){
                      queue.add(new Pair(currNode.right, yCoordinator + 1)); 
                }
           }
       }
      result.removeIf(ele -> ele.size() == 0);
        return result;
    }
    private int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getDepth(node.left),getDepth(node.right)) + 1;
    }
    private class Pair{
        TreeNode node;
        int yCoordinator;
        public Pair(TreeNode node, int yCoordinator){
            this.node = node;
            this.yCoordinator = yCoordinator;
        }
    }
}
