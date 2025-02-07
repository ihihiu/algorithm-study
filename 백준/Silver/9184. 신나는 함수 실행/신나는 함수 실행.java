import java.util.*;

public class Main {
    public static int[][][] dp = new int[21][21][21];;

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return dp[20][20][20] = w(20, 20, 20);
        if (dp[a][b][c] != 0) return dp[a][b][c];
        if (a < b && b < c) {
            return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        while (true) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            if (a == -1 && b == -1 && c == -1) break;
            System.out.println("w(" + a +", " + b + ", " + c + ") = " + w(a, b, c));
        }

    }
}