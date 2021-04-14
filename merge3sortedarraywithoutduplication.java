class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int[] a = new int[]{-100, -10, -1, -1, 0, 0, 0, 1, 1, 5};
       int[] b = new int[]{-90, -2, 0, 0, 0, 3, 5, 5};
       int[] c = new int[]{-20, -1, 0, 0, 1, 4, 4};
       List<Integer>result = new ArrayList<>();
       int aPointer = 0, bPointer = 0, cPointer = 0;
       int aLen = a.length, bLen = b.length, cLen = c.length;
       while(aPointer < aLen || bPointer < bLen || cPointer < cLen){
           int temp = Integer.MAX_VALUE;
           if(aPointer < aLen){
               temp = Math.min(temp,a[aPointer]);
           }
           
           if(bPointer < bLen){
               temp = Math.min(temp,b[bPointer]);
           }
           
           if(cPointer < cLen){
               temp = Math.min(temp,c[cPointer]);
           }  
           //remove duplicates from result.
           if(result.size() == 0 || result.get(result.size() - 1) != temp){
               result.add(temp);
           }
           if(aPointer < aLen && temp == a[aPointer]){
               aPointer++;
           }
           
           if(bPointer < bLen && temp == b[bPointer]){
               bPointer++;
           }
           
           if(cPointer < cLen && temp == c[cPointer]){
               cPointer++;
           }
         
       }
    while(aPointer < aLen && aPointer - 1 >= 0 && a[aPointer - 1] == a[aPointer]){
          result.add(a[aPointer]);
          aPointer++;
      }
       
    while(bPointer < bLen && bPointer - 1 >= 0 && b[bPointer - 1] == b[bPointer]){
          result.add(b[bPointer]);
          bPointer++;
      }
          while(cPointer < cLen && cPointer - 1 >= 0 && c[cPointer - 1] == c[cPointer]){
          result.add(c[cPointer]);
          cPointer++;
      }
       for(int ele : result){
           System.out.println(ele);
       } 
    }
}
