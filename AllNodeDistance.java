/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,List<TreeNode>>meToNei = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Set<TreeNode>visit = new HashSet<>();
        buildGraph(root,null);
        
        List<Integer>result = new ArrayList<>();
        Queue<TreeNode>queue = new LinkedList<>();
        queue.add(target);
        visit.add(target);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(K == 0){
                for(int i = 0; i < size; i++){
                    TreeNode curr = queue.poll();
                    result.add(curr.val);      
                }
                 return result;
            }

            for(int j = 0; j < size; j++){
                TreeNode currNode = queue.poll();
                for(TreeNode ele : meToNei.get(currNode)){
                     if(visit.contains(ele)){
                        continue;
                    } 
                    visit.add(ele);
                    queue.add(ele);
                }
            }
            K--;
        }
        // while(!queue.isEmpty()){
        //     System.out.println("hello");
        // }
        return new ArrayList<>();
        
    }
    private void buildGraph(TreeNode node, TreeNode parent){
        if(node == null)return;
        if(!meToNei.containsKey(node)){
            meToNei.put(node, new ArrayList<>());
            if(parent != null){
                meToNei.get(node).add(parent);
                 meToNei.get(parent).add(node);
            }
            buildGraph(node.left,node);
            buildGraph(node.right,node);
        }

    }
}
