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
        if(root == null) return new ArrayList<>();
       int height = getHeight(root);
        //total buckets
       int totalBuckets =  2 * height - 1;
       int rootIndex =  height - 1;
       Queue<Node>queue = new LinkedList<>();
       queue.add(new Node(root, rootIndex));
       List<List<Integer>>result = new ArrayList<>();
        
        //initialized all the bucekts;
        for(int i = 0; i < totalBuckets; i++){
            result.add(new ArrayList<>());
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                int index = curr.yCoordinator;
                result.get(index).add(curr.root.val);
                if(curr.root.left != null){
                    queue.add(new Node(curr.root.left,index - 1));
                }
                if(curr.root.right != null){
                    queue.add(new Node(curr.root.right,index + 1));
                }
            }
        }
        result.removeIf(ele -> (ele.size() == 0));
        return result;
    }
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left) , getHeight(root.right)) + 1;
    }
    private class Node{
        TreeNode root;
        int yCoordinator;
        public Node(TreeNode root, int yCoordinator){
            this.root = root;
            this.yCoordinator = yCoordinator;
        }
    }
    
}
//题目：level order

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>>result = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer>temp = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }

 
            }
            result.add(temp);
        }
        return result;
    }
}
////题目：lzigzagLevelOrder

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root== null)return new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                
                if(result.size() == level){
                    List<Integer>temp = new ArrayList<>();
                    temp.add(curr.val);
                    result.add(temp);
                }else if(level % 2 != 0){
                    result.get(level).add(0,curr.val);
                }else{
                 result.get(level).add(curr.val);
                }
                
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            level++;
        }
        return result;
    }
}
