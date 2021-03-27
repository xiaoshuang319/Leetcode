/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    final static String NULL_SYMBOL = "#";
    final static String DELIMETER = ",";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NULL_SYMBOL;
        return root.val + DELIMETER + serialize(root.left) + DELIMETER + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]dataArray = data.split(DELIMETER);
        Queue<String>input = new LinkedList<>();
        input.addAll(Arrays.asList(dataArray));
        return helper(input);
    }
    public TreeNode helper(Queue<String>input){
         String currVal = input.poll();
        if(currVal.equals("#")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(currVal));
        root.left = helper(input);
        root.right = helper(input);
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
