import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int[] answer = new int[5];

        int x = 0, y = 0;

        outer:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*') {
                    while (true) {
                        i++;
                        if (board[i][j - 1] == '*') {
                            x = i;
                            y = j;
                            break outer;
                        }
                    }
                }
            }
        }

        System.out.println((x + 1) + " " + (y + 1));

        int nx = x, ny = y;
        int cnt = 0;
        //왼쪽 팔
        while (ny - 1 >= 0 && board[nx][ny - 1] == '*') {
            ny--;
            cnt++;
        }
        answer[0] = cnt;

        nx = x;
        ny = y;
        cnt = 0;
        // 오른쪽 팔
        while (ny + 1 < N && board[nx][ny + 1] == '*') {
            ny++;
            cnt++;
        }
        answer[1] = cnt;

        nx = x;
        ny = y;
        cnt = 0;

        // 허리
        while (nx + 1 < N && board[nx + 1][ny] == '*') {
            nx++;
            cnt++;
        }
        answer[2] = cnt;

        x = nx;

        //왼쪽 다리
        nx = x;
        ny = y - 1;
        cnt = 0;
        while (nx + 1 < N && board[nx + 1][ny] == '*') {
            nx++;
            cnt++;
        }
        answer[3] = cnt;

        //오른쪽 다리
        nx = x;
        ny = y + 1;
        cnt = 0;
        while (nx + 1 < N && board[nx + 1][ny] == '*') {
            nx++;
            cnt++;
        }
        answer[4] = cnt;

        for (int v : answer) {
            System.out.print(v + " ");
        }


    }
}