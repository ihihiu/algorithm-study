import java.util.*;
class Solution {
    static int[][][] ch;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static int calculate(String[] grid, int i, int j, int k) {
        int cnt = 0;
        while (true) {
            if (ch[i][j][k] == 1) break;
            cnt++;
            ch[i][j][k] = 1;
            if (grid[i].charAt(j) == 'L') {
                k = (k + 3) % 4;
            }
            else if (grid[i].charAt(j) == 'R') {
                k = (k + 1) % 4;
            }
            
            i = (i + dx[k] + n) % n;
            j = (j + dy[k] + m) % m;
        }
        return cnt;
    }
    
    public int[] solution(String[] grid) {
        ArrayList<Integer> res = new ArrayList<>();
        n = grid.length;
        m = grid[0].length();
        ch = new int[n][m][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (ch[i][j][k] == 0){
                        res.add(calculate(grid, i, j, k));
                    }
                }
            }
        }
        Collections.sort(res);
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}