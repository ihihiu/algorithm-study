import javax.naming.PartialResultException;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        int[][][] dp = new int[N][M][3];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i][j], 1000000);
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j][0] = board[0][j];
            dp[0][j][1] = board[0][j];
            dp[0][j][2] = board[0][j];
        }



        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    int preJ = j + (d - 1);
                    if (preJ < 0 || preJ >= M) continue;
                    for (int preD = 0; preD < 3; preD++) {
                        if (preD == d) continue;
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i - 1][preJ][preD] + board[i][j]);
                    }
                }
            }
        }


        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N - 1][j][d]);
            }
        }
        System.out.println(answer);

    }
}