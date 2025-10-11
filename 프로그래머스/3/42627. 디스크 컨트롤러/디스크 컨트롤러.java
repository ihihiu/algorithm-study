import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int N = jobs.length;
        
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(new int[]{jobs[i][0], jobs[i][1], i});
        }
        
        // (소요시간, 요청 시각, 작업 번호)
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else return a[1] - b[1];
            } else return a[0] - b[0];
        });
        
        Collections.sort(list, (a, b) -> a[0] - b[0]);
        
        int time = list.get(0)[0];
        int idx = 0;
        
        while (true) {
            // 종료 조건
            if (idx >= N && pQ.isEmpty()) break;
            
            while (idx < N && list.get(idx)[0] <= time) {
                int[] x = list.get(idx);
                pQ.add(new int[]{x[1], x[0], x[2]});
                idx++;
            }
            
            if (pQ.isEmpty() && idx < N) {
                time = list.get(idx)[0];
            }
            else {            
                int[] now = pQ.poll();
                answer += (time + now[0] - now[1]);
                time += now[0];
            }
        }
        
        return answer / N;
    }
}