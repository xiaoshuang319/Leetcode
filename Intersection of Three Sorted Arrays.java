//method1:bainary search
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer>result = new ArrayList<>();
        for(int ele : arr1){
            int index2 = binaryFind(arr2, ele);
            int index3 = binaryFind(arr3,ele);
            if(index2 != -1 && index3 != -1){
                result.add(ele);
            }
        }
        return result;
    }
    private int binaryFind(int[] arr, int target){
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }  
        }
        return -1;
    }
}
//method2: find min to move index

class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
      List<Integer>result = new ArrayList<>();
       int index1 = 0, index2 = 0, index3 = 0;
        while(index1 < arr1.length && index2 < arr2.length && index3 < arr3.length){
            int min = Math.min(arr1[index1],Math.min(arr2[index2],arr3[index3] ) );
            if(arr1[index1] == min && arr2[index2] == min && arr3[index3] == min){
                result.add(min);
            }
            if(min == arr1[index1]){
                index1++;
            }
            if(min == arr2[index2]){
                index2++;
            }
            if(min == arr3[index3]){
                index3++;
            }
        }
        return result;
    }
}
