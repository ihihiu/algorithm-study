import java.awt.image.ImageProducer;
import java.io.*;
import java.util.*;

class Main {
    static int R, C;
    static char[][] board;
    static int[][] swans = new int[2][2];
    static boolean[][] ch;
    static Queue<int[]> meltQueue = new LinkedList<>();
    static Queue<int[]> swanQueue = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        ch = new boolean[R][C];

        int idx = 0;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'L') {
                    swans[idx][0] = i;
                    swans[idx++][1] = j;
                }
                if (board[i][j] != 'X') {
                    meltQueue.add(new int[]{i, j});
                }
            }
        }

        swanQueue.add(new int[]{swans[0][0], swans[0][1]});
        ch[swans[0][0]][swans[0][1]] = true;

        int answer = 0;
        while (!swansCanMeet()) {
            melt();
            answer++;
        }
        System.out.println(answer);
    }

    private static void melt() {
        int size = meltQueue.size();
        for (int i = 0; i < size; i++) {
            int[] now = meltQueue.poll();
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (board[nx][ny] == 'X') {
                    board[nx][ny] = '.';
                    meltQueue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean swansCanMeet() {
        Queue<int[]> nextQueue = new LinkedList<>();

        while (!swanQueue.isEmpty()) {
            int[] now = swanQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || ch[nx][ny]) continue;
                ch[nx][ny] = true;
                if (nx == swans[1][0] && ny == swans[1][1]) return true;
                else if (board[nx][ny] == 'X') nextQueue.add(new int[]{nx, ny});
                else swanQueue.add(new int[]{nx, ny});
            }
        }
        swanQueue = nextQueue;
        return false;
    }

}