import java.io.*;
import java.util.*;

class Main {
    static int N, min, max;
    static int[] arr, ops;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ops = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            ops[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int depth, int tmp) {
        if (depth == N) {
            min = Math.min(tmp, min);
            max = Math.max(tmp, max);
        }
        else {
            if (ops[0] >= 1) {
                ops[0]--;
                dfs(depth + 1, tmp + arr[depth]);
                ops[0]++;
            }
            if (ops[1] >= 1) {
                ops[1]--;
                dfs(depth + 1, tmp - arr[depth]);
                ops[1]++;
            }
            if (ops[2] >= 1) {
                ops[2]--;
                dfs(depth + 1, tmp * arr[depth]);
                ops[2]++;
            }
            if (ops[3] >= 1) {
                ops[3]--;
                dfs(depth + 1, divide(tmp, arr[depth]));
                ops[3]++;
            }
        }

    }

    public static int divide(int a, int b) {
        if (a < 0 && b > 0 || a > 0 && b < 0) {
            return -(Math.abs(a) / Math.abs(b));
        } else {
            return a / b;
        }
    }


}

