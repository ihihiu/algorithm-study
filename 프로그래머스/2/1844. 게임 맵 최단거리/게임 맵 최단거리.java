import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        boolean[][] ch = new boolean[n][m];
        ch[0][0] = true;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || ch[nx][ny] == true || maps[nx][ny] == 0) continue;
                    ch[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            if (ch[n - 1][m - 1] == true) return answer + 1;
        }
        
        return -1;
    }
}