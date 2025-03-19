import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        int[][][] dp = new int[n][m][3];
        //0 : 위에서 내려온 경우, 1 : 왼쪽, 2 : 오른쪽
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        //(0,0) 위에서 내려오는 경우 X
        dp[0][0][0] = board[0][0];
        //첫번째 행 초기화 (오른쪽 이동)
        for (int j = 1; j < m; j++) {
            dp[0][j][0] = dp[0][j - 1][0] + board[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //위에서 내려오는 경우
                dp[i][j][0] = dp[i -1][j][0];
                //왼쪽에서 오는 경우
                if (j > 0) dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][1]);
                //오른쪽에서 오는 경우
                if(j < m - 1) dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][2]);
                dp[i][j][0] += board[i][j];

            }
            dp[i][0][1] = dp[i][0][0];
            for (int j = 1; j < m; j++) {
                dp[i][j][1] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + board[i][j];
            }

            dp[i][m - 1][2] = dp[i][m - 1][0];
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j][2] = Math.max(dp[i][j + 1][0], dp[i][j + 1][2]) + board[i][j];
            }
        }

        // 최종 결과 출력
        int result = Math.max(dp[n - 1][m - 1][0], Math.max(dp[n - 1][m - 1][1], dp[n - 1][m - 1][2]));
        System.out.println(result);

    }
}