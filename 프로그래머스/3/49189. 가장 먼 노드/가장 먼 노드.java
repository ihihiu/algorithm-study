import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        HashMap<Integer, ArrayList<Integer>> sh = new HashMap<>();
        
        for (int i = 0; i <= n; i++) {
            sh.put(i, new ArrayList<>());
        }
        
        for (int[] ver : edge) {
            sh.get(ver[0]).add(ver[1]);
            sh.get(ver[1]).add(ver[0]);
        }
        
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            answer = queue.size();
            for (int i = 0; i < answer; i++) {
                int now = queue.poll();
                for (int key : sh.get(now)) {
                    if (!visited[key]) {
                        visited[key] = true;
                        queue.add(key);
                    }
                }
            }
        }
        
        
        return answer;
    }
}