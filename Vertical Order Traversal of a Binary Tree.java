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
// Integer, Map<Integer, PriortiyQueue<>)   PriorityQueue     
// col           row,val          
// -2,           2,(4)                         (4)
// -1,           1,(2)                         (2)  
//  0,           (0,1)(2,(5,6))                (1)(5,6)
//  1,           1,3                           (3)
//  2,           2,7                          () 7)            
    
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>colToNode = new TreeMap<>();
        helper(root, 0, 0, colToNode);//O(n)
        List<List<Integer>>result = new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer>> ele : colToNode.values()){
            List<Integer>tempResult = new ArrayList<>();
            for(PriorityQueue<Integer>value : ele.values()){
               while(!value.isEmpty()){
                   tempResult.add(value.poll());
               }
            }
            result.add(tempResult); 
        }
        return result;
    }
    private void helper(TreeNode node, int col, int row,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>>colToNode){
        if(node==null)return;
        if(!colToNode.containsKey(col)){
            colToNode.put(col, new TreeMap<>());
        }
        if(!colToNode.get(col).containsKey(row)){
            colToNode.get(col).put(row, new PriorityQueue<>());
        }
        colToNode.get(col).get(row).add(node.val);
        helper(node.left, col - 1, row + 1,colToNode);
        helper(node.right, col + 1, row + 1,colToNode);
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
