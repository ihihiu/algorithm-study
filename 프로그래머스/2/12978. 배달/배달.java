import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] x : road) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
            graph.get(x[1]).add(new int[]{x[0], x[2]});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 500001);
        dist[1] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[1] > dist[now[0]]) continue;
            for (int[] x : graph.get(now[0])) {
                if (now[1] + x[1] < dist[x[0]]) {
                    dist[x[0]] = now[1] + x[1];
                    queue.offer(new int[]{x[0], dist[x[0]]});
                    if (dist[x[0]] <= K) set.add(x[0]);
                }
            }
            
        }
        

        return set.size();
    }
}