class Solution {
    public int maximumSwap(int num) {
        char[] input = String.valueOf(num).toCharArray(); //[2,7,3,6];
        int[]eleToPos = new int[10];
        for(int i = 0; i < input.length; i++){
            eleToPos[input[i] - '0'] = i;
        }
        for(int j = 0; j <input.length; j++){
            for(int d = 9; d > (input[j] - '0'); d--){
                if(eleToPos[d] > j){
                    swap(input,eleToPos[d],  j);
                    return Integer.valueOf(String.valueOf(input));
                  
                }
            }
        }
        return num;
    }
    private void swap(char[]ele, int a, int b){
        char temp = ele[a];
        ele[a] = ele[b];
        ele[b] = temp;
    }
}
