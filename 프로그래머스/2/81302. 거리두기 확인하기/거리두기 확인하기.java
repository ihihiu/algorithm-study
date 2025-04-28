import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        for (int i = 0; i < n; i++) {
            String[] board = places[i];
            boolean flag = true;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (board[x].charAt(y) == 'P') {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{x, y});
                        boolean[][] ch = new boolean[5][5];
                        ch[x][y] = true;
                        for (int r = 0; r < 2; r++) {
                            int size = queue.size();
                            for (int k = 0; k < size; k++) {
                                int[] now = queue.poll();
                                for (int l = 0; l < 4; l++) {
                                    int nx = now[0] + dx[l];
                                    int ny = now[1] + dy[l];
                                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || board[nx].charAt(ny) == 'X' || ch[nx][ny] == true) continue;
                                    if (board[nx].charAt(ny) == 'P') {
                                        flag = false;
                                        break;
                                    }
                                    queue.offer(new int[]{nx, ny});
                                    ch[nx][ny] = true;
                                }
                                
                            }
                        }
                    }
                }
            }
            if (flag) answer[i] = 1;
        }
        
        return answer;
    }
}