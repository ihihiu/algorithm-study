import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int idx = 0;
        for (String[] x : places) {
            int[][] cost = new int[5][5];
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (flag && x[i].charAt(j) == 'P') {
                        Queue<int[]> queue = new ArrayDeque<>();
                        queue.offer(new int[]{i, j});
                        int[][] ch = new int[5][5];
                        ch[i][j] = 1;
                        for (int r = 0; r < 2; r++) {
                            int size = queue.size();
                            for (int k = 0; k < size; k++) {
                                int[] now = queue.poll();
                                for (int d = 0; d < 4; d++) {
                                    int nx = now[0] + dx[d];
                                    int ny = now[1] + dy[d];
                                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || x[nx].charAt(ny) == 'X' || ch[nx][ny] == 1) continue;
                                    if (x[nx].charAt(ny) == 'P') {
                                        flag = false;
                                        break;
                                    }
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
            if (flag) answer[idx] = 1;
            idx++;
        }
        return answer;
    }
}