class Solution {
    public List<List<String>> partition(String s) {
      
        List<List<String>>result = new ArrayList<>();
        backtrackHelper(s, 0, new ArrayList<>(),result);
        return result;
    }
    private void backtrackHelper(String s, int start, List<String>path, List<List<String>>result){
        if(start == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i = start + 1; i <= s.length(); i++){// do not forget == because it is subtring
            String substring = s.substring(start, i);
            if(isValid(substring)){  //backtracking valid pandlidrome substring.
                
                path.add(substring);
                backtrackHelper(s, i, path, result); //need to backtacking element behind, instead of starting from the begin
                path.remove(path.size() - 1);
            }
        }
    }
    private boolean isValid(String s){
        int start = 0, end = s.length() - 1;
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
