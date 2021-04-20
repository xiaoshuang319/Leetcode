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
//two pointer + stack
class Solution {
    public TreeNode str2tree(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        Stack<TreeNode>stack = new Stack<>();
        int idx = 0, len = s.length();
        while(idx < len){
            char c = s.charAt(idx);
            if(Character.isDigit(c) || c == '-' ){
                int startIndex = idx;
                while(idx < len && (Character.isDigit(s.charAt(idx)) || s.charAt(idx) =='-' )){
                    idx++;
                }
                int nodeVal = Integer.parseInt(s.substring(startIndex, idx));
                TreeNode node = new TreeNode(nodeVal);
                if(!stack.isEmpty()){
                    TreeNode root = stack.peek();
                    if(root.left == null){
                        root.left = node;
                    }else{
                        root.right = node;
                    }
                }
                stack.add(node);
                continue;
            }else if(c == ')'){
                stack.pop();
            }
            idx++; 
        }
        return stack.pop();
    }
}
