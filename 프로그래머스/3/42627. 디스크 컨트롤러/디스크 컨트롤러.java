import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;
        int time = 0, cnt = 0, idx = 0;
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while (cnt < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pQ.offer(jobs[idx]);
                idx++;
            }
            if (!pQ.isEmpty()) {
                int[] x = pQ.poll();
                answer += (time - x[0] + x[1]);
                time += x[1];
                cnt++;
            }
            else {
                time = jobs[idx][0];
            }
        }
        
        return answer / n;
    }
}