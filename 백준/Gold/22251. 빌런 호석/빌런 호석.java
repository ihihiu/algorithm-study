import java.io.*;
import java.util.*;

class Main{
    static int N, K, P, X;
    static String[] display = {
            "1111110", "0110000", "1101101", "1111001", "0110011",
            "1011011", "1011111", "1110000", "1111111", "1111011"
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] current = toDigit(X);

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            int[] num = toDigit(i);
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += countDiff(current[j], num[j]);
            }

            if (sum <= P) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    static int[] toDigit(int X) {
        int[] digit = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            digit[i] = X % 10;
            X /= 10;
        }
        return digit;
    }

    static int countDiff(int a, int b) {
        int diff = 0;
        for (int i = 0; i < 7; i++) {
            if (display[a].charAt(i) != display[b].charAt(i)) {
                diff++;
            }
        }
        return diff;
    }

}

