import java.io.*;
import java.util.*;

class Main {
    public static int N, M;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int lt = 1, rt = 0;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            rt = Math.max(rt, x);
        }
        M = Integer.parseInt(br.readLine());

        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (check(mid)) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);

    }

    static boolean check(int mid) {
        int total = 0;
        for (int x : arr) {
            if (x < mid) total += x;
            else total += mid;
        }
        return total <= M ? true : false;
    }

}