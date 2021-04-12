class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int[]res = new int[1];
        helper(nestedList,res,1);
        return res[0];
    }
    private void helper(List<NestedInteger> nestedList, int[]res, int depth){
        for(NestedInteger ele : nestedList){
            if(ele.isInteger()){
                res[0] += ele.getInteger() * depth;
            }else{
               helper(ele.getList(), res,depth + 1);
            }
      
           
        }
    }
}
