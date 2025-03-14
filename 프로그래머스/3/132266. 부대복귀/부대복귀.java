import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
        for (int[] x : roads) {
            int a = x[0];
            int b = x[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] cost = new int[n + 1];
        Arrays.fill(cost, 1000000);
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pQ.offer(new int[]{destination, 0});
        cost[destination] = 0;
        
        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            for (int next : graph.get(now[0])) {
                if (now[1] > cost[next]) continue;
                if (cost[next] > now[1] + 1) {
                    cost[next] = now[1] + 1;
                    pQ.offer(new int[]{next, cost[next]});
                }
            }
        }
        for (int i = 0; i < sources.length; i++) {
            answer[i] = cost[sources[i]] == 1000000 ? -1 : cost[sources[i]];
        }
        return answer;
    }
}