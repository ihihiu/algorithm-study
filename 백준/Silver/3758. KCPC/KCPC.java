import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int Id = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] score = new int[N + 1][K + 1];
            int[] last = new int[N + 1];
            int[] cnt = new int[N + 1];

            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                score[i][j] = Math.max(score[i][j], s);
                last[i] = m;
                cnt[i]++;
            }
            LinkedList<int[]> list = new LinkedList<>();
            for (int x = 1; x <= N; x++) {
                int total = Arrays.stream(score[x]).sum();
                list.add(new int[]{x, total, cnt[x], last[x]});
            }

            Collections.sort(list, (a, b) -> {
                if (a[1] != b[1]) return b[1] - a[1];
                else if (a[2] != b[2]) return a[2] - b[2];
                return a[3] - b[3];
            });


            for (int x = 1; x <= N; x++) {
                if (list.get(x - 1)[0] == Id) {
                    System.out.println(x);
                    break;
                }
            }
        }
    }
}