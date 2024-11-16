import java.util.*;
class Solution {
    public int getTime(String x) {
        int h = Integer.parseInt(x.split(":")[0]);
        int m = Integer.parseInt(x.split(":")[1]);
        return h * 60 + m;
    }
    public String[] solution(String[][] plans) {
        int n = plans.length;
        String[] answer = new String[n];
        LinkedList<int[]> planList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            planList.offer(new int[]{i, getTime(plans[i][1]), Integer.parseInt(plans[i][2])});
        }
        Collections.sort(planList, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[3] - a[3]);
        int[] p = planList.poll();
        int order = 0;
        pQ.offer(new int[]{p[0], p[1], p[2], order++});
        int endTime = p[1] + p[2];
        int idx = 0;
        while (!planList.isEmpty()) {
            int[] now = planList.poll();
            while (!pQ.isEmpty() && now[1] >= endTime) {
                int[] x = pQ.poll();
                answer[idx++] = plans[x[0]][0];
                if (pQ.isEmpty()) break;
                else {
                    int[] y = pQ.poll();
                    pQ.offer(new int[]{y[0], endTime, y[2], y[3]});
                    endTime += pQ.peek()[2];
                }
            }
            if (!pQ.isEmpty()) {
                int[] x = pQ.poll();
                pQ.offer(new int[]{x[0], now[1], endTime - now[1], order++});
            }
            pQ.offer(new int[]{now[0], now[1], now[2], order++});
            endTime = now[1] + now[2];
        }
        while (!pQ.isEmpty()) {
            answer[idx++] = plans[pQ.poll()[0]][0];
        }
        
        
        return answer;
    }
}