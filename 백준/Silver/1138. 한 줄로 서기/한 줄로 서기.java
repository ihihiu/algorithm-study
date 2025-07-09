import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int ord = Integer.parseInt(st.nextToken());

            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (answer[j] == -1) {
                    if (cnt == ord) {
                        answer[j] = i + 1;
                        break;
                    }
                    cnt++;
                }
            }
        }

        for (int x : answer) System.out.print(x + " ");
    }
}
