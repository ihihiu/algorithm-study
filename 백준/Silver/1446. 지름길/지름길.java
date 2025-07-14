import javax.naming.PartialResultException;
import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) dp[i] = i;

        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end <= D) list.add(new int[]{start, end, dist});
        }

        for (int i = 1; i <= D; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            for (int[] x : list) {
                if (x[1] == i) {
                    dp[i] = Math.min(dp[i], dp[x[0]] + x[2]);
                }
            }
        }

        System.out.println(dp[D]);
    }

}