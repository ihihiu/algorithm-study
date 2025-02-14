import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] ch = new int[n][m];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && ch[i][j] == 0) {
                    int sum = maps[i].charAt(j) - '0';
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    ch[i][j] = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int r = 0; r < size; r++) {
                            int[] now = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx < 0 || nx >= n || ny < 0 || ny >= m || maps[nx].charAt(ny) == 'X' || ch[nx][ny] == 1) continue;
                                sum += (maps[nx].charAt(ny)) - '0';
                                ch[nx][ny] = 1;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                    res.add(sum);
                }
            }
        }
        if (res.isEmpty()) return new int[]{-1};
        Collections.sort(res);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) answer[i] = res.get(i);
        return answer;
    }
}