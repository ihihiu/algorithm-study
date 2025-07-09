import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            pQ.add(new int[]{arr[N - 1][i], N - 1, i});
        }

        for (int i = 0; i < N - 1; i++) {
            int[] now = pQ.poll();
            pQ.add(new int[]{arr[now[1] - 1][now[2]], now[1] - 1, now[2]});
        }

        System.out.println(pQ.poll()[0]);

    }
}