import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, answer = 0;

        Map<Integer, Integer> sh = new HashMap<>();

        for (int rt = 0; rt < N; rt++) {
            sh.put(arr[rt], sh.getOrDefault(arr[rt], 0) + 1);

            while (sh.get(arr[rt]) > K) {
                sh.put(arr[lt], sh.get(arr[lt]) - 1);
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);
    }
}