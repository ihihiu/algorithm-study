import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<int[]> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        Collections.sort(list,(a,  b)->{
            if (a[1] != b[1]) return b[1] - a[1];
            if (a[2] != b[2]) return b[2] - a[2];
            return b[3] - a[3];
        });


        int nowRank = 1;
        int cnt = 1;
        int[] prev = list.get(0);

        if (prev[0] == K) {
            System.out.println(nowRank);
        }
        else {
            for (int i = 1; i < N; i++) {
                int[] now = list.get(i);
                if (now[1] == prev[1] && now[2] == prev[2] && now[3] == prev[3]) {
                    cnt++;
                } else {
                    nowRank = i + 1;
                    cnt = 1;
                }

                if (now[0] == K) {
                    System.out.println(nowRank);
                    break;
                }
                prev = now;
            }
        }


    }
}