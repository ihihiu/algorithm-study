import java.util.*;
class Solution {
    static int[] parent;
    
    static public int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    
    static public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px > py) {
            parent[py] = px;
        } else parent[px] = py;
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int i = 0; i < n; i++) {
            int[] row = computers[i];
            for (int j = 0; j < row.length; j++) {
                if (i == j) continue;
                if (row[j] == 1) union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent[i]));
        }
        answer = set.size();
        
        return answer;
    }
}