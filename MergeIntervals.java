class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0)return new int[][]{};
        Arrays.sort(intervals,new customizedCompare());
        List<int[]>temp = new ArrayList<>();
        temp.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] ele = intervals[i];
            int end = temp.get(temp.size() - 1)[1];
            int start = ele[0];
            if(end >= start){
                int newStart = Math.min(ele[0], temp.get(temp.size() - 1)[0]);
                int newEnd = Math.max(ele[1],temp.get(temp.size() - 1)[1]);
                temp.set(temp.size() - 1, new int[]{newStart,newEnd });
            }else{
                temp.add(ele);
            }
        }
        int[][]result = new int[temp.size()][2];
        int index = 0;
        for(int[] ele : temp){
            result[index][0] = ele[0];
            result[index][1] = ele[1];
            index++;
        }
        return result;
        
    }
    private class customizedCompare implements Comparator<int[]>{
        @Override
        public int compare(int[]o1, int[]o2){
            return Integer.compare(o1[0],o2[0]);
        }
    }
}
