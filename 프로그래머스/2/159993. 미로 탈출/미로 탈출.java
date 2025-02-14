import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        int[][] dist = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int sx = 0, sy = 0, ex = 0, ey = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                else if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
                else if (maps[i].charAt(j) == 'L') {
                    int L = 0;
                    queue.offer(new int[]{i, j});
                    dist[i][j] = -1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        L++;
                        for (int r = 0; r < size; r++) {
                            int[] now = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X' || dist[nx][ny] != 0) continue;
                                dist[nx][ny] = L;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
        if (dist[sx][sy] == 0 || dist[ex][ey] == 0) return -1;
        
        return dist[sx][sy] + dist[ex][ey];
    }
}