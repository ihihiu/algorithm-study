import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int r = 1; r <= 125; r++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            System.out.print("Problem " + r + ": ");
            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int[][] cost = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[0][0] = board[0][0];

            // x좌표, y좌표, 비용
            PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pQ.offer(new int[]{0, 0, cost[0][0]});

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};

            while (!pQ.isEmpty()) {
                int[] now = pQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (cost[now[0]][now[1]] + board[nx][ny] < cost[nx][ny]) {
                        cost[nx][ny] = cost[now[0]][now[1]] + board[nx][ny];
                        pQ.offer(new int[]{nx, ny, cost[nx][ny]});
                    }
                }
            }

            System.out.println(cost[N - 1][N - 1]);

        }

    }
}

