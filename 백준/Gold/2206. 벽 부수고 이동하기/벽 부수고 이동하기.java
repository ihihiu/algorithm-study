import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        //0은 안 부숨, 1은 부숨
        boolean[][][] visited = new boolean[N][M][2];

        Queue<int[]> queue = new LinkedList<>();
        // x좌표, y좌표, 거리, 벽을 부쉈는지
        queue.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.println(now[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (board[nx][ny] == 0 && !visited[nx][ny][now[3]]) {
                    visited[nx][ny][now[3]] = true;
                    queue.offer(new int[]{nx, ny, now[2] + 1, now[3]});
                }

                if (board[nx][ny] == 1 && now[3] == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new int[]{nx, ny, now[2] + 1, 1});
                }
            }
        }

        System.out.println(-1);
    }
}

