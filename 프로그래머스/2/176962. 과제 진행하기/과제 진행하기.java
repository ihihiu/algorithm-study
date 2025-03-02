import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.valueOf(x.split(":")[0]);
        int m = Integer.valueOf(x.split(":")[1]);
        return h * 60 + m;
    }
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        HashMap<Integer, String> sh = new HashMap<>();
        LinkedList<int[]> info = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] x = plans[i];
            sh.put(i, x[0]);
            int a = getTime(x[1]);
            int b = Integer.valueOf(x[2]);
            info.add(new int[]{a, b, i});
        }
        Collections.sort(info, (a, b) -> a[0] - b[0]);
        int ansIdx = 0, idx = 0;
        int endTime = 0;
        Stack<int[]> stack = new Stack<>();
        while (!info.isEmpty() || !stack.isEmpty()) {
            if (info.isEmpty()) {
                answer[ansIdx++] = sh.get(stack.pop()[2]);
            }
            else if (stack.isEmpty()) {
                stack.push(info.poll());
                endTime = stack.peek()[0];
            }
            else {
                if (endTime + stack.peek()[1] > info.peek()[0]) {
                    stack.peek()[1] -= info.peek()[0] - endTime;
                    stack.push(info.poll());
                    endTime = stack.peek()[0];
                }
                else {
                    endTime += stack.peek()[1];
                    answer[ansIdx++] = sh.get(stack.pop()[2]);
                }
            }
            
          
        }
        
        
        
        
        
        return answer;
    }
}