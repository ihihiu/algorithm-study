import java.util.*;
class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] x : wires) {
            int a = x[0];
            int b = x[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            int[] ch = new int[n + 1];
            ch[a] = 1;
            ch[b] = 1;
            int cnt = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(a);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int now = queue.poll();
                    for (int x : graph.get(now)) {
                        if (ch[x] == 0) {
                            queue.offer(x);
                            ch[x] = 1;
                            cnt++;
                        }
                    }
                }
            }
            answer = Math.min(answer, Math.abs(n - cnt - cnt));
        }
        
        return answer;
    }
}