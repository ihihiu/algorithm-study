import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        
        for (int[] x : road) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
            graph.get(x[1]).add(new int[]{x[0], x[2]});
        }
        
        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        pQ.offer(new int[]{1, 0});
        
        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            for (int[] next : graph.get(now[0])) {
                if (now[1] >= cost[next[0]]) continue;
                if (now[1] + next[1] < cost[next[0]]) {
                    cost[next[0]] = now[1] + next[1];
                    pQ.offer(new int[] {next[0], cost[next[0]]});
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (cost[i] <= K) answer++;
        }
        
        return answer;
    }
}