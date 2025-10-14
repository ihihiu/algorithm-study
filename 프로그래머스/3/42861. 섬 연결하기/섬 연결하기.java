import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] c : costs) {
            int a = c[0];
            int b = c[1];
            int cost = c[2];
            graph.get(a).add(new int[]{b, cost});
            graph.get(b).add(new int[]{a, cost});
        }

        
        boolean[] visited = new boolean[n];
        
        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pQ.offer(new int[]{0, 0});
        
        while (!pQ.isEmpty()) {
            int[] now = pQ.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            answer += now[1];
            
            for (int[] next : graph.get(now[0])) {
                if (!visited[next[0]]) pQ.offer(next);
            }
            
        }
        
        
        return answer;
    }
}