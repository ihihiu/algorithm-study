import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    static public void dfs(int x, int[][] computers) {
        visited[x] = true;
        
        for (int i = 0; i < computers[x].length; i++) {
            if (computers[x][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}