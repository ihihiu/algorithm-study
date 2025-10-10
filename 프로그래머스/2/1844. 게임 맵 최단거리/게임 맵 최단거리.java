import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        
        int L = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int r = 0; r < 4; r++) {
                    int x = now[0] + dx[r];
                    int y = now[1] + dy[r];
                    if (x < 0 || x >= N || y < 0 || y >= M || maps[x][y] == 0 || visited[x][y]) continue;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            L++;
            if (visited[N - 1][M - 1]) break;
        }
        
        
        return visited[N - 1][M - 1] == false ? - 1 : L;
    }
}