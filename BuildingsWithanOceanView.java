class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer>temp = new ArrayList<>();
        int maxHeight = -1;
        int len = heights.length;
        for(int i = len - 1; i >= 0; i--){
            if(heights[i] > maxHeight){
                maxHeight = heights[i];
                temp.add(i);
            }
        }
        int size = temp.size();
        int[] res = new int[size];
        int index = 0;
        while(index < size){
            res[index] = temp.get(size - 1 - index);
            index++;
        }
        return res;
    }
}
