import java.util.*;
class Solution {
    static int[] parent;
    public static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px < py) {
            parent[px] = py;
        } else {
            parent[py] = px;
        }
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n + 1];
        for (int i = 1; i < n; i++) parent[i] = i;
        
        List<int[]> edges = new ArrayList<>();
        for (int[] c : costs) edges.add(c);
        edges.sort((a, b) -> a[2] - b[2]);
        
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            int cost = e[2];
        
            if (find(x) != find(y)) {
                union(x, y);
                answer += cost;
            }
        }
        
        
        return answer;
    }
}