//path sum
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)return false;
        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }
     return  hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
  
}
//path sum II

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null)return new ArrayList<>();
        List<List<Integer>>res = new ArrayList<>();
        helper(root, new ArrayList<>(), res, targetSum);
        return res;
    }
    private void helper(TreeNode node, List<Integer>path, List<List<Integer>>result, int targetSum){
        if(node == null)return;
        path.add(node.val);
        if(node.left == null && node.right == null && targetSum == node.val){
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }else{
            helper(node.left, path, result, targetSum - node.val);
            helper(node.right, path, result, targetSum - node.val);
        }
        path.remove(path.size() - 1); //deal with parent
    }
}
//path Sum III
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer,Integer>sumToFreq = new HashMap<>();
        sumToFreq.put(0,1);
        return helper(root,0,sumToFreq,targetSum);
        
    }
    private int helper(TreeNode root, int currSum, Map<Integer,Integer>sumToFreq, int target){
        if(root == null) return 0;
        currSum += root.val;
        int res = sumToFreq.getOrDefault(currSum - target,0);
        sumToFreq.put(currSum, sumToFreq.getOrDefault(currSum, 0) + 1);
        res += helper(root.left,currSum, sumToFreq, target) + helper(root.right,currSum, sumToFreq, target);
        sumToFreq.put(currSum, sumToFreq.get(currSum) - 1);
        return res;
    }
}



//sum root to leaf number 
//method1

class Solution {
    public int sumNumbers(TreeNode root) {
        List<String>pathResult = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        findPath(root,pathResult,path);
        int result = 0;
        for(String ele : pathResult){
            result += Integer.valueOf(ele);
        }
        return result;
    }
    private void findPath(TreeNode node, List<String>pathResult, StringBuilder path){
        if(node == null)return;
        path.append(node.val);
        if(node.left == null && node.right == null){
            pathResult.add(path.toString());
            path.deleteCharAt(path.length() - 1);
            return;
        }else{
            findPath(node.left, pathResult, path);
            findPath(node.right, pathResult, path);
        }
         path.deleteCharAt(path.length() - 1);
    }
}
//method2
//     1
// 2      3
// at 2 : 1(currsum) * 10 + 2 = 12
//at 3 : 1(currsum) * 10 + 3 = 13

class Solution {
    public int sumNumbers(TreeNode root) {
        return getSum(root,0);
    }
    private int getSum(TreeNode node, int currSum){
        if(node == null) return 0;//left child 或者right child 为null
        currSum = currSum * 10 + node.val; //需要把currSUm*10 + parent的值 传递给child
        if(node.left == null && node.right == null){
            return currSum;
        }
        int leftSum = getSum(node.left, currSum);
        int rightSum = getSum(node.right, currSum);
        return leftSum + rightSum;
        
//binaryTreePaths
        
 class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result = new ArrayList<>();
        inorder(root,new ArrayList<>(), result);
        return result;
    }
    private void inorder(TreeNode node, List<String> path, List<String>result){
        if(node == null){
            return;
        }
        //一路往下的操作
        path.add(String.valueOf(node.val));
        if(node.left == null && node.right == null){ 
            result.add(String.join("->",path));
            path.remove(path.size() - 1);
            return;
        }
        inorder(node.left, path, result);
        inorder(node.right, path, result); 
         //左边和右边走完之后，返回上一层的操作
        path.remove(path.size() - 1);
    }
}
//permuation
        class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        Set<Integer>visited = new HashSet<>();
        helper(nums, path, result,visited );
        return result;
    }
    private void helper(int[]nums,List<Integer>path, List<List<Integer>>result, Set<Integer>visited){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
              if(visited.contains(nums[i])){
                  continue;
              }
              path.add(nums[i]);
              visited.add(nums[i]);
              helper(nums, path, result, visited);
              path.remove(path.size() - 1);
              visited.remove(nums[i]);
        }

    }
}

 //combine
  class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, k, 1);
        return result;
        
    }
    private void helper(List<List<Integer>>result, List<Integer>path, int n, int k, int startIndex){
        if(k == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i <= n; i++){
            path.add(i);
            helper(result,path,n,k - 1, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
   
   //letter combintion
    //本质：对一个word进行backtrack直到word的end position
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Character,String>digitToChars = new HashMap<>();
        digitToChars.put('2',"abc");
        digitToChars.put('3',"def");
        digitToChars.put('4',"ghi");
        digitToChars.put('5',"jkl");
        digitToChars.put('6',"mno");
        digitToChars.put('7',"pqrs");
        digitToChars.put('8',"tuv");
        digitToChars.put('9',"wxyz");
        List<String>result = new ArrayList<>();
        helper(result,new StringBuilder(), digitToChars, 0,digits);
        return result;
    }
    private void helper(List<String>result, StringBuilder path, Map<Character,String>digitToChars, int index, String digits){
         
        if(index == digits.length()){
            result.add(path.toString());
            return;
        }
        char curr = digits.charAt(index);
        for(int i = 0; i < digitToChars.get(curr).length(); i++){//对每个数字所代表的string backtrack
            path.append(digitToChars.get(curr).charAt(i));
            helper(result,path,digitToChars,index + 1,digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
