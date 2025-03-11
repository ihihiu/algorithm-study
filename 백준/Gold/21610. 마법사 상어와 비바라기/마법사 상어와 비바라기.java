import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};


        LinkedList<int[]> tmp = new LinkedList<>();
        tmp.add(new int[]{n - 1, 0});
        tmp.add(new int[]{n - 1, 1});
        tmp.add(new int[]{n - 2, 0});
        tmp.add(new int[]{n - 2, 1});

        for (int t = 0; t < m; t++) {
            int dir = sc.nextInt() - 1;
            int d = sc.nextInt();
            int[][] ch = new int[n][n];
            int size = tmp.size();
            for (int i = 0; i < size; i++) {
                int[] now = tmp.poll();
                //이동 좌표 구하기
                int x = (now[0] + dx[dir] * d + 100 * n) % n;
                int y = (now[1] + dy[dir] * d + 100 * n) % n;
                ch[x][y] = 1;
                board[x][y]++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ch[i][j] == 1) {
                        int cnt = 0;
                        for (int[] xy : new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}}) {
                            int nx = i + xy[0];
                            int ny = j + xy[1];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] <= 0) continue;
                            cnt++;
                        }
                        board[i][j] += cnt;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ch[i][j] == 1) continue;
                    if (board[i][j] >= 2) {
                        board[i][j] -= 2;
                        tmp.add(new int[]{i, j});
                    }
                }
            }

        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer += board[i][j];
            }
        }
        System.out.println(answer);
    }
}