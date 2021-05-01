class Solution {
    public int minAreaRect(int[][] points) {
        int rowLen = points.length, colLen = points[0].length;
        Map<Integer,Set<Integer>>xCoordinator = new HashMap<>();
       for(int[] p : points){
           if(!xCoordinator.containsKey(p[0])){
               xCoordinator.put(p[0], new HashSet<>());
           }
            xCoordinator.get(p[0]).add(p[1]);
       }
        int result = Integer.MAX_VALUE;
        //find the ohter two points has same xCoordinatior with two point sitting in the diagnoze
        for(int[]point1 : points){
            for(int[]point2: points){
                //cannot form dignose
                if(point1[0] == point2[0] || point1[1] == point2[1] ){
                    continue;
                }
                if( xCoordinator.get(point1[0]).contains(point2[1])  && xCoordinator.get(point2[0]).contains(point1[1])  ){
                    result = Math.min(result, Math.abs(point1[0] - point2[0]) * Math.abs(point1[1] - point2[1]) );
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
