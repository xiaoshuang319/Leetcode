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
