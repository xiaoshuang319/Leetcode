//mehtod1; TLE
class Solution {
    public int numFriendRequests(int[] ages) {
        if(ages == null || ages.length == 0){
            return 0;
        }
        int len = ages.length;
        int count = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(isRequest(ages,i,j))count++;
            }
        }
        return count;
    }
    private boolean isRequest(int[]ages, int i, int j){
        if(i == j)return false;
        if(ages[j] <= ages[i] * 0.5 + 7) return false;
        if(ages[j] > ages[i]) return false;
        if(ages[j] > 100 && ages[i] < 100) return false;
        return true;
    }
}

//method2:
//年龄的统计数量有两种情况。
//第一种情况是a 和b 是不同的年龄，比如a 岁的有2人，b 岁的有3人，发请求只能是年纪大的发给年纪小的，所以一共的请求数量是 2 x 3. 
//第二种情况是a和b是相同年纪，比如都是a，b岁的有3人，那这同岁的3人可以相互发多少请求呢？实际上是排列问题，因为同岁的A人可以给B发请求，B也可以给A发请求，P(3，2), 就是从3个人当中取两个，组成排列，一共有多少种取法，一共有3 x (3 - 1) 种取法。如果同a岁的人有5个，他们之间能发多少请求呢？一共是 5 x (5 -1) = 20种取法
class Solution {
    public int numFriendRequests(int[] ages) {
        if(ages == null || ages.length == 0){
            return 0;
        }
        Map<Integer,Integer>ageToFreq = new HashMap<>();
        
        for(int i = 0; i < ages.length; i++){
            ageToFreq.put(ages[i], ageToFreq.getOrDefault(ages[i],0) + 1);
        }
        int len = ages.length;
        int count = 0;
        for(int a : ageToFreq.keySet()){
            for(int b : ageToFreq.keySet()){
              //case1:
              //case2:
                if(isRequest(a,b))count += ageToFreq.get(a) * ( a == b ? ageToFreq.get(b) - 1 : ageToFreq.get(b));
            }
        }
        return count;
    }
    private boolean isRequest(int i, int j){
        if(j <= i * 0.5 + 7) return false;
        if(j > i) return false;
        if(j > 100 && i < 100) return false;
        return true;
    }
}
//Presum 
//Person A can make friend request to Person B => when Person B'age meet ( 0.5*ages[A] + 7, A ]
//the number age sit in ( 0.5* A  + 7, A ] => A - (0.5*A - 7 + 1) + 1 => A - 0.5*A + 7 
class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[]ageFreq = new int[121], preSumAge = new int[121];
        for(int ele : ages){
            ageFreq[ele]++;
        }
        for(int i = 1; i <= 120; i++){
            preSumAge[i] = ageFreq[i] + preSumAge[i - 1];
        }
        int result = 0;
        //B range (0.5*A + 7, A] => A > 15
        for(int i = 15; i <= 120; i++){
            if(preSumAge[i] == 0)continue;
            int count = preSumAge[i] - preSumAge[i / 2 + 7];
            result += count * ageFreq[i]  - ageFreq[i];
        }
        return result;
    }
}
