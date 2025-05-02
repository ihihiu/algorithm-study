import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.parseInt(x.split(":")[0]) * 60;
        int m = Integer.parseInt(x.split(":")[1]);
        return h + m;
    }
    
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        
        LinkedList<int[]> list = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new int[]{i, getTime(plans[i][1]), Integer.parseInt(plans[i][2])});
        }
        
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        
        //(시간, 인덱스)
        Stack<int[]> stack = new Stack<>();
        
        int time = 0;
        int idx = 0;
        
        while (!list.isEmpty()) {
            int[] now = list.poll();
            while (!stack.isEmpty() && stack.peek()[0] + time <= now[1]) {
                int[] s = stack.pop();
                time += s[0];
                answer[idx] = plans[s[1]][0];
                idx++;
            }
            if (!stack.isEmpty()) {
                int[] s = stack.pop();
                stack.push(new int[] {s[0] - (now[1] - time), s[1]});
            }
            stack.push(new int[]{now[2], now[0]});
            time = now[1];
            
        }
        
        while (!stack.isEmpty()) {
            answer[idx] = plans[stack.pop()[1]][0];
            idx++;
        }
        
        return answer;
    }
}