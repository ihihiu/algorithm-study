import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = -1;
        int n = board.length;
        int m = board[0].length();
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int[][] ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    int L = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        L++;
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
                                if (ch[nx][ny] == 0) {
                                    ch[nx][ny] = 1;
                                    if (board[nx].charAt(ny) == 'G') {
                                        return L;
                                    }
                                    queue.offer(new int[]{nx, ny});
                                }
                                
                            }
                        }
                    }
                }
            }
        }
        
        
        return answer;
    }
}