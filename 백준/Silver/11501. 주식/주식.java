import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = prices[N - 1];
            long answer = 0;
            for (int i = N - 2; i >= 0; i--) {
                if (prices[i] <= maxPrice) {
                    answer += maxPrice - prices[i];
                } else {
                    maxPrice = prices[i];
                }
            }
            System.out.println(answer);
        }
    }
}