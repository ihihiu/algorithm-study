import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] board;
    static List<int[]> arr;
    static int C;
    static int answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][][] dirs = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}
    };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        arr = new ArrayList<>();

        List<int[]> cctv5 = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] >= 1 && board[i][j] <= 4) {
                    arr.add(new int[]{board[i][j], i, j});
                } else if (board[i][j] == 5) {
                    cctv5.add(new int[]{i, j});
                }
            }
        }




        for (int[] x : cctv5) {
            for (int i = 0; i < 4; i++) {
                int nx = x[0] + dx[i];
                int ny = x[1] + dy[i];
                while (true) {
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M || board[nx][ny] == 6) break;
                    if (board[nx][ny] == 0) board[nx][ny] = 7;
                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        C = arr.size();

        dfs(0);

        System.out.println(answer);
    }

    public static void dfs(int depth) {
        if (depth == C) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) {
                        sum++;
                    }
                }
            }
            answer = Math.min(answer, sum);
            return;
        }
        int number = arr.get(depth)[0];
        int x = arr.get(depth)[1];
        int y = arr.get(depth)[2];

        for (int[] dir : dirs[number]) {
            List<int[]> changed = new ArrayList<>();
            for (int d : dir) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (board[nx][ny] == 6) break;
                    if (board[nx][ny] == 0) {
                        board[nx][ny] = 7;
                        changed.add(new int[]{nx, ny});
                    }
                    nx += dx[d];
                    ny += dy[d];
                }
            }
            dfs(depth + 1);
            for (int[] value : changed) {
                board[value[0]][value[1]] = 0;
            }
        }

    }
}