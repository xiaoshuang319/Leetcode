class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer>deque = new ArrayDeque<>();
        int[]result = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            //size > k
            if(!deque.isEmpty() && deque.peekFirst() == i - k){
                deque.pollFirst();
            }
            //found element bigger than current max within the widnow
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
          //before adding current element into the deque make sure, it pass the first two conditions
            deque.offerLast(i);
            if(i >= k - 1){
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }
        return result;
    }
}
