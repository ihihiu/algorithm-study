import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (S == 1) {
                for (int j = num; j <= N; j += num) {
                    if (arr[j - 1] == 0) {
                        arr[j - 1] = 1;
                    } else {
                        arr[j - 1] = 0;
                    }
                }
            } else {
                int lt = num - 1;
                int rt = num - 1;
                while (lt - 1 >= 0 && rt + 1 < N) {
                    if (arr[lt - 1] == arr[rt + 1]) {
                        lt--;
                        rt++;
                    } else break;
                }
                for (int j = lt; j <= rt; j++) {
                    if (arr[j] == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = 0;
                    }
                }
            }

        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
            if ((i + 1) % 20 == 0) System.out.println();
        }

    }

}