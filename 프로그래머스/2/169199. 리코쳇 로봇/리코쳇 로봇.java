import java.util.*;
class Solution {
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        int[][] ch = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    queue.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    int L = 0;
                    while(!queue.isEmpty()) {
                        L++;
                        int size = queue.size();
                        for (int r = 0; r < size; r++) {
                            int[] now = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx].charAt(ny) == 'D') continue;
                                while (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx].charAt(ny) != 'D') {
                                    nx += dx[k];
                                    ny += dy[k];
                                }
                                nx -= dx[k];
                                ny -= dy[k];
                                if (board[nx].charAt(ny) == 'G') return L;
                                if (ch[nx][ny] == 0) {
                                    ch[nx][ny] = 1;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}