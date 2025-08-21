import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());

        Queue<int[]> jQueue = new LinkedList<>();
        Queue<int[]> fQueue = new LinkedList<>();

        char[][] board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == 'J') {
                    jQueue.offer(new int[]{i, j});
                    if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                        System.out.println(1);
                        return;
                    }
                }
                if (board[i][j] == 'F') fQueue.offer(new int[]{i, j});
            }
        }

        int answer = -1;
        int L = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!jQueue.isEmpty()) {
            L++;
            int fSize = fQueue.size();
            for (int r = 0; r < fSize; r++) {
                int[] fNow = fQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fNow[0] + dx[i];
                    int ny = fNow[1] + dy[i];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || board[nx][ny] == '#' || board[nx][ny] == 'F') {
                        continue;
                    }
                    board[nx][ny] = 'F';
                    fQueue.offer(new int[]{nx, ny});
                }
            }

            int jSize = jQueue.size();
            for (int r = 0; r < jSize; r++) {
                int[] jNow = jQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = jNow[0] + dx[i];
                    int ny = jNow[1] + dy[i];
                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || board[nx][ny] == '#' || board[nx][ny] == 'F' || board[nx][ny] == 'J') {
                        continue;
                    }
                    if (nx == 0 || nx == R - 1 || ny == 0 || ny == C - 1) {
                        answer = L;
                        break;
                    }
                    board[nx][ny] = 'J';
                    jQueue.offer(new int[]{nx, ny});
                }
            }
            if (answer != -1) break;
        }

        if (answer == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(answer);
        }

    }
}

