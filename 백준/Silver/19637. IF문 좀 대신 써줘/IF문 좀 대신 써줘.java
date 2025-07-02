import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] title = new String[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            int lt = 0, rt = N - 1, idx = 0;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (power[mid] < x) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
            sb.append(title[lt]).append("\n");
        }

        System.out.println(sb);
    }
}