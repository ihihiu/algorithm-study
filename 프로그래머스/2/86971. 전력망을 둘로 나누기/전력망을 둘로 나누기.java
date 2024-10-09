import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int[] ch = new int[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            ch[1] = 1;
            int cnt = 1;
            while(!queue.isEmpty()) {
                int now = queue.poll();
                for (int x : graph.get(now)) {
                    if (ch[x] == 0) {
                        ch[x] = 1;
                        queue.offer(x);
                        cnt++;
                    }
                }
            }
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            graph.get(a).add(b);
            graph.get(b).add(a);
            
        }
        
        return answer;
    }
}