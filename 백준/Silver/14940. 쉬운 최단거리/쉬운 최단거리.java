import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        int[][] answer = new int[n][m];
        boolean[][] visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;;
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int r = 0; r < 4; r++) {
                    int nx = now[0] + dx[r];
                    int ny = now[1] + dy[r];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] == 0 || visited[nx][ny]) continue;

                    answer[nx][ny] = now[2] + 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, now[2] + 1});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) System.out.print("0 ");
                else if (!visited[i][j]) System.out.print("-1 ");
                else System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}