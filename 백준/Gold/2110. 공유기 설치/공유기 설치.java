import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = arr[N - 1] - arr[0];
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int pos = 0;
            int cnt = 1;

            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[pos] >= mid) {
                    pos = i;
                    cnt++;
                }
            }

            if (cnt < C) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }
}

