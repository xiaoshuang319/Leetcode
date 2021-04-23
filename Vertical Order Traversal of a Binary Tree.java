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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int height = getHeight(root);
        int totalBuckets = 2 * height - 1;
        int midIndex = height - 1;
        List<List<Integer>>result = new ArrayList<>();
        for(int i = 0; i < totalBuckets; i++){
            result.add(new ArrayList<>());
        }
        Queue<Node>queue = new LinkedList<>();
        queue.add(new Node(root,midIndex));
        while(!queue.isEmpty()){
            int size = queue.size();
            Map<Integer,List<Integer>>indexToValue = new HashMap<>();
            for(int i = 0; i < size; i++){
                Node currNode = queue.poll();
                int index = currNode.yCoordinator;
                if(indexToValue.containsKey(index)){
                    indexToValue.get(index).add(currNode.node.val);
                }else{
                    List<Integer>temp = new ArrayList<>();
                    temp.add(currNode.node.val);
                    indexToValue.put(index,temp );
                }
                if(currNode.node.left != null){
                    queue.add(new Node(currNode.node.left,index - 1));
                }
                if(currNode.node.right != null){
                    queue.add(new Node(currNode.node.right,index + 1));
                }
            }
            for(Map.Entry<Integer,List<Integer>>ele : indexToValue.entrySet()){
                List<Integer>temp = ele.getValue();
                Collections.sort(temp);
                result.get(ele.getKey()).addAll(temp);
            }
            
        }
       result.removeIf(ele -> ele.size() == 0);
        return result;
    }
    private class Node{
        TreeNode node;
        int yCoordinator;
        public Node(TreeNode node, int yCoordinator){
            this.node = node;
            this.yCoordinator = yCoordinator;
        }
    }
    private int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
//similar: Binary Tree Vertical Order Traversal
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
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>>result = new ArrayList<>();
        int height = getHeight(root);
        int totalBuckets = 2 * height - 1;
        for(int i = 0; i < totalBuckets; i++){
            List<Integer>temp = new ArrayList<>();
            result.add(temp);
        }
        int midIndex = height - 1;
      
        Queue<Node>queue =  new LinkedList<>();
        queue.add(new Node(root, midIndex));
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node curr = queue.poll();
                int currIndex = curr.index;
                 result.get(currIndex).add(curr.node.val);
                if(curr.node.left != null ){
                    queue.add(new Node(curr.node.left,currIndex - 1));
                }
                if(curr.node.right != null){
                   queue.add(new Node(curr.node.right, currIndex + 1));
                }
            }
        }
        result.removeIf(ele -> ele.size() == 0);
        return result;
    }
    private int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        return Math.max(getHeight(node.left),getHeight(node.right)) + 1;
    }
    private class Node{
        TreeNode node;
        int index;
        public Node(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
}
