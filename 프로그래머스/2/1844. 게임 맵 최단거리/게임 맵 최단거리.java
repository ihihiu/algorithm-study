import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] ch = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        ch[0][0] = 1;
        int L = 1;
        while (!queue.isEmpty()) {
            L++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx][ny] == 0) continue;
                    if (ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        if (nx == n - 1 && ny == m - 1) {
                            return L;
                        }
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return -1;
    }
}