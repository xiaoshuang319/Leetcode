class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String>digitToChars = new HashMap<>();
        digitToChars.put('2',"abc");
        digitToChars.put('3',"def");
        digitToChars.put('4',"ghi");
        digitToChars.put('5',"jkl");
        digitToChars.put('6',"mno");
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
        for(int i = 0; i < digitToChars.get(curr).length(); i++){
            path.append(digitToChars.get(curr).charAt(i));
            helper(result,path,digitToChars,i + 1,digits);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
