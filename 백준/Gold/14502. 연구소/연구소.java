import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static int answer = 0;
    static int[][] board;

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) map[i] = board[i].clone();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] != 0) continue;
                queue.add(new int[]{nx, ny});
                map[nx][ny] = 2;
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(answer, cnt);


    }

    static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        dfs(depth + 1);
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(answer);
    }
}