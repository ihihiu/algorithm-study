import java.io.*;
import java.util.*;

class Main {
    static int N;
    static char[] current, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        current = br.readLine().toCharArray();
        target = br.readLine().toCharArray();

        int result1 = simulate(false);

        int result2 = simulate(true);

        int answer = Math.min(result1, result2);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }

    static int simulate(boolean pressFirst) {
        char[] bulbs = current.clone();
        int count = 0;

        if (pressFirst) {
            press(bulbs, 0);
            count++;
        }

        for (int i = 1; i < N; i++) {
            if (bulbs[i - 1] != target[i - 1]) {
                press(bulbs, i);
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            if (bulbs[i] != target[i]) return Integer.MAX_VALUE;
        }

        return count;
    }

    static void press(char[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < N) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }

    }

}

