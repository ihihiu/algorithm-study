import java.util.*;
class Solution {
    public boolean bfs(String[] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int[][] ch = new int[5][5];
        ch[i][j] = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
    
        int round = 0;
        while (!queue.isEmpty() && round < 2) {
            round++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] now = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || board[nx].charAt(ny) == 'X' || ch[nx][ny] == 1) continue;
                    if (board[nx].charAt(ny) == 'P') {
                        return false;
                    }
                    queue.offer(new int[]{nx, ny});
                    ch[nx][ny] = 1;
                }
            }
        }
        
        return true;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);

        
        for (int idx = 0; idx < 5; idx++) {
            String[] board = places[idx];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i].charAt(j) == 'P') {
                        if(!bfs(board, i, j)) answer[idx] = 0; 
                    }
                }
         
            }
            
        }
        return answer;
    }
}