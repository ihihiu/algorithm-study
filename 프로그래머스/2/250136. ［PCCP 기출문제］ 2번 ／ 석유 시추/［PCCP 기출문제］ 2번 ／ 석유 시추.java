import java.util.*;
class Solution {
    int n, m;
    int[][] ch;
    int idx, cnt;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public void DFS(int[][] land, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && land[nx][ny] == 1) {
                land[nx][ny] = 0;
                ch[nx][ny] = idx;
                cnt++;
                DFS(land, nx, ny);
            }
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        ch = new int[n][m];
        HashMap<Integer, Integer> sh = new HashMap<>();
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1) {
                    cnt = 1;
                    land[i][j] = 0;
                    ch[i][j] = ++idx;
                    DFS(land, i, j);
                    sh.put(idx, cnt);
                }
            }
        }
        for (int j = 0; j < m; j++) {
            Set<Integer> set = new HashSet<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (ch[i][j] != 0) {
                    set.add(ch[i][j]);
                }
            }
            for (int x : set) sum += sh.get(x);
            answer = Math.max(answer, sum);
        }
        
        
        return answer;
    }
}