import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] cost = new int[n][m];
        int sx = 0, sy = 0, ex = 0, ey = 0, lx = 0, ly = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                }
                else if (maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                }
                else if (maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        Queue<int[]> queue = new ArrayDeque();
        queue.offer(new int[]{lx, ly});
        cost[lx][ly] = 1;
        int L = 0;
        while (!queue.isEmpty()) {
            L++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (maps[nx].charAt(ny) != 'X' && cost[nx][ny] == 0) {
                        cost[nx][ny] = L;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        if (cost[sx][sy] == 0 || cost[ex][ey] == 0) return -1;
        
        
        return cost[sx][sy] + cost[ex][ey];
    }
}