class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int breakRuleIndex = -1;
        for(int i = len - 1; i >= 0; i--){
            if(i - 1 >= 0 && nums[i] > nums[i - 1]){
                breakRuleIndex = i - 1;
                break;
            }  
        }
        if(breakRuleIndex == -1){
            int switchStart = 0, switchEnd = len - 1;
            while(switchStart < switchEnd){
                if(nums[switchStart] > nums[switchEnd]){
                    int temp = nums[switchStart];
                    nums[switchStart] = nums[switchEnd];
                    nums[switchEnd] = temp;
                }
                switchStart++;
                switchEnd--;
            }           
        }else{
            for(int i = len - 1; i > breakRuleIndex; i--){
                if(nums[i] > nums[breakRuleIndex]){
                    int temp = nums[i];
                    nums[i] = nums[breakRuleIndex];
                    nums[breakRuleIndex] = temp;
                    break;
                } 
            }
            int switchStart = breakRuleIndex + 1, switchEnd = len - 1;
            while(switchStart < switchEnd){
                if(nums[switchStart] > nums[switchEnd]){
                    int temp = nums[switchStart];
                    nums[switchStart] = nums[switchEnd];
                    nums[switchEnd] = temp;
                }
                switchStart++;
                switchEnd--;
            }
       }

    }
}
                 
// 123             5     6       4      3
// 1235346
