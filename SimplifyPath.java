class Solution {
    public String simplifyPath(String path) {
        //split function:split any character in the front of "/"
        String[]input = path.split("/");
        Stack<String>stack = new Stack<>();
        for(String ele : input){
            System.out.println(ele.length());
            if(!stack.isEmpty() && ele.equals("..")){
                stack.pop();
            }else if(!ele.equals("..") && !ele.equals(".") && !ele.equals("")){
                stack.add(ele);
            }
        }
        List<String>result = new ArrayList<String>(stack);
        return "/" + String.join("/",result);
        
    }
}
    
   
