class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>result = new ArrayList<>();
        helper("", n, n, result);
        return result;
    }
    private void helper(String path, int numLeftUsed, int numRightUsed,List<String>result){
        if(numLeftUsed == 0 && numRightUsed == 0){
            result.add(path);
            return;
        }
        if(numLeftUsed > 0){
            helper(path+"(", numLeftUsed - 1, numRightUsed, result);
        }
        
        if(numRightUsed >0 && numRightUsed > numLeftUsed){
            helper(path+")", numLeftUsed, numRightUsed - 1, result);
        }
    }
}
