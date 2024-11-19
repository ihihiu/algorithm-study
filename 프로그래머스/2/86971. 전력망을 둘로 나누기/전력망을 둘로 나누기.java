import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<Integer>());
        for (int[] x : wires) {
            graph.get(x[0]).add(x[1]);
            graph.get(x[1]).add(x[0]);
        }
        for (int[] x : wires) {
            int[] ch = new int[n + 1];
            ch[x[1]] = 1;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(x[0]);
            int cnt = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int r = 0; r < size; r++) {
                    int now = queue.poll();
                    if (ch[now] == 1) continue;
                    ch[now] = 1;
                    cnt++;
                    for (int next : graph.get(now)) {
                        if (ch[next] == 0) {
                            queue.offer(next);
                        }
                    }
                }
            }
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
            
        }
        return answer;
    }
}