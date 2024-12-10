import java.util.*;

class Main {
    static int answer;
    static int n,  m;
    static int[][] board;

    //0:북, 1:동, 2:남, 3:서 (반시계 : 0 -> 3 -> 2 -> 1)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void dfs(int x, int y, int dir) {
        board[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            dir -= 1;
            if (dir == -1) dir = 3;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                answer++;
                dfs(nx, ny, dir);
                //일반적인 dfs는 가다가 길이 막히면 되돌아와서 해당 위치부터 계산하지만, 이 문제는 return
                return;
            }

        }
        int d = (dir + 2) % 4;
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] != 1) dfs(nx, ny, dir);
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        answer = 1;
        board = new int[n][m];
        int r = kb.nextInt();
        int c = kb.nextInt();
        int d = kb.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        dfs(r, c, d);
        System.out.println(answer);

    }
}