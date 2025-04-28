import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            int x = wire[0];
            int y = wire[1];
            int[] ch = new int[n + 1];
            int sum = 1;
            ch[x] = 1;
            ch[y] = 1;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(x);
            
            while (!queue.isEmpty()) {
                int a = queue.poll();
                for (int now : graph.get(a)) {
                    if (ch[now] == 0) {
                        ch[now] = 1;
                        sum++;
                        queue.offer(now);
                    }
                }
            }
            answer = Math.min(answer, Math.abs(n - sum - sum));
        }
        
        return answer;
    }
}