import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][] board;
    static int answer = 0;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int pre) {
        if (x == N - 1 && y == N - 1) {
            answer++;
        }
        for (int i = 0; i < 3; i++) {
            if ((pre == 0 && i == 1) || (pre == 1 && i == 0)) continue;
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= N || ny >= N || board[nx][ny] == 1) continue;
            if (i == 2) {
                if (board[x + 1][y] == 1 || board[x][y + 1] == 1) {
                    continue;
                }
            }
            dfs(nx, ny, i);
        }

    }

}

