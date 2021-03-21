class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimeArray = new int[n];
        Stack<Log> stack = new Stack<>();

        for (String log : logs) {
            String[] contents = log.split("\\:");
            int id = Integer.parseInt(contents[0]);
            String startOrEndSign = contents[1];
            int timeStamp = Integer.parseInt(contents[2]);

            if (startOrEndSign.equals("start")) {
                Log newLog = new Log(id, timeStamp);
                stack.add(newLog);
            } else {
                // startOrEndSign equals "end"
                Log preLog = stack.pop();
                int endTime = timeStamp;
                int startTime = preLog.startTime;

                int exclusiveTime = endTime - startTime + 1 - preLog.coveredByChildren;
                exclusiveTimeArray[id] += exclusiveTime;

                if (!stack.isEmpty()) {
                    int totalTime = endTime - startTime + 1;
                    stack.peek().coveredByChildren += totalTime;
                }
            }
        }

        return exclusiveTimeArray;
    }
    
    private class Log {
        int id;
        int startTime;
        int coveredByChildren;

        public Log(int id, int startTime) {
            this.id = id;
            this.startTime = startTime;
        }
    }
}
