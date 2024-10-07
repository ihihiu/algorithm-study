import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] x : edge) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pQ.offer(new int[]{1, 0});
        distance[1] = 0;
        while(!pQ.isEmpty()) {
            int[] now = pQ.poll();
            if (distance[now[0]] < now[1]) continue;
            for (int x : graph.get(now[0])) {
                if (distance[x] > now[1] + 1) {
                    distance[x] = now[1] + 1;
                    pQ.offer(new int[] {x, distance[x]});
                }
            }
            
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, distance[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (max == distance[i]) answer++;
        }
        return answer;
    }
}