import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == P && score <= arr[arr.length - 1]) {
            System.out.println(-1);
        } else {
            int rank = 1;
            for (int i = 0; i < arr.length; i++) {
                if (score < arr[i]) {
                    rank++;
                } else break;
            }
            System.out.println(rank);
        }
    }

}