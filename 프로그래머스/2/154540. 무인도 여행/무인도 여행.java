import java.util.*;
class Solution {
    static int tmp;
    static int n, m;
    static int[][] ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public void dfs(int x, int y, String[] maps) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if (Character.isDigit(maps[nx].charAt(ny)) && ch[nx][ny] == 0) {
                tmp += maps[nx].charAt(ny) - '0';
                ch[nx][ny] = 1;
                dfs(nx, ny, maps);
            }
        }
    }
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        ArrayList<Integer> arr = new ArrayList<>();
        ch = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(maps[i].charAt(j)) && ch[i][j] == 0) {
                    tmp = maps[i].charAt(j) - '0';
                    ch[i][j] = 1;
                    dfs(i, j, maps);
                    arr.add(tmp);
                }
            }
        }
        if (arr.isEmpty()) return new int[]{-1};
        Collections.sort(arr);
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) answer[i] = arr.get(i); 
        return answer;
    }
}