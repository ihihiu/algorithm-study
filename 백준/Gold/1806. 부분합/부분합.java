import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        for (int rt = 0; rt < N; rt++) {
            sum += arr[rt];
            while (sum >= S) {
                answer = Math.min(answer, rt - lt + 1);
                sum -= arr[lt++];
            }

        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}

