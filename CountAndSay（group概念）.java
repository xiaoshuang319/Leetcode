//group概念
//当发现对具有相同特性的元素操作时，就是要引入group的概念，group往往需要一个start指针（哪里开始）， 因为group结束的位置是知道的。。
//当发现另一个group是，把当前的group打包并处理（根据题意）， 然后跟新start（下一个group开始的位置）

class Solution {
    public String countAndSay(int n) {
        if(n == 1)return "1";
        String content = "1";
        for(int i = 2; i <= n; i++){
            content = say(content);
        }
        return content;
    }
    private String say(String con){
        int count = 1;
        StringBuilder result = new StringBuilder();
        for(int i = 1; i < con.length(); i++){
            if(con.charAt(i) == con.charAt(i - 1)){ //相同的元素
                count++;
            }else{
                //另外一个group了要开始了
                //step：打包之前的group
                result.append(count);
                result.append(con.charAt(i - 1));
                //跟新start
                count=1;
            }
        }
        //corner case content = “1”
         result.append(count);
         result.append(con.charAt(con.length() - 1));
         return result.toString();
    }
}


class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0)return new ArrayList<>();
        List<String>reuslt = new ArrayList<>();
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] + 1== nums[i]){//相同的元素
                continue;
            }else{
               //另外一个group了要开始了
                //step：打包之前的group
                reuslt.add(group(start, nums[i - 1]));
                start = nums[i];
            }
        }
        //corner case [6,9]
        reuslt.add(group(start,nums[nums.length - 1]));
        return reuslt;
        
    }
    private String group(int start, int end){
        if(start == end){
            return start+"";
        }else{
            return start +"->"+ end;
        }
    }
}
