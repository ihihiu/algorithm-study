import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        int answer = 0;
        for (int[] nowX : list) {
            for (int[] nowY : list) {
                int x = nowX[0];
                int y = nowY[1];

                if (x > N - L) x = N - L;
                if (y > M - L) y = M - L;

                int cnt = 0;
                for (int[] dot : list) {
                    if (x <= dot[0] && x + L >= dot[0] && y <= dot[1] && y + L >= dot[1]) {
                        cnt++;
                    }

                }
                answer = Math.max(answer, cnt);
            }
        }

        System.out.println(K - answer);
    }
}

