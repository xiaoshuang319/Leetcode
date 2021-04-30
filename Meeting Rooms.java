class Solution {
 
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,new CustomizedComparator());
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i-1][1] > intervals[i][0]){
                return false;
            }
        }
        return true;
    }
    private class CustomizedComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[0] - b[0];
        }
    }
}

 
