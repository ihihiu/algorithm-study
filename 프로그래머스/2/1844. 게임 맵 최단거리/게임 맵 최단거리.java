import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int[][] ch = new int[n][m];
        ch[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0,});
        int L = 1;
        while (!queue.isEmpty()) {
            L++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0 || ch[nx][ny] == 1) continue;
                    ch[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
            if (ch[n - 1][m - 1] == 1) return L;
        }
        
        
        
        
        
        return -1;
    }
}