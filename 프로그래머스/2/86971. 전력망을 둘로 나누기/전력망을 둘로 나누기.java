import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        }
        
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        boolean[] ch = new boolean[n + 1];
                
        for (int[] wire : wires) {
            Arrays.fill(ch, false);
            ch[0] = true;
            
            int a = wire[0];
            int b = wire[1];
            
            Queue<Integer> queue = new LinkedList<>();
            ch[a] = true;
            ch[b] = true;
            
            queue.offer(a);
            
            while (!queue.isEmpty()) {
                int now = queue.poll();
                for (int next : graph.get(now)) {
                    if (!ch[next]) {
                        ch[next] = true;
                        queue.offer(next);
                    }
                }
            }
            
            int cnt = -1;
            for (int i = 1; i <= n; i++) {
                if (ch[i]) cnt++;
            }
            
            answer = Math.min(answer, Math.abs(n - cnt - cnt));
            
        }
        
        
        return answer;
    }
}