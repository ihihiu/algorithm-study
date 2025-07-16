import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + k - 1];
        for (int i = 0; i < k - 1; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            arr[N + i] = n;
        }

        for (int i = k - 1; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> sh = new HashMap();
        for (int i = 0; i < k - 1; i++) {
            sh.put(arr[i], sh.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        int answer = 0;
        for (int rt = k - 1; rt < N + k - 1; rt++) {
            sh.put(arr[rt], sh.getOrDefault(arr[rt], 0) + 1);
            int cnt = sh.size();
            if (!sh.containsKey(c)) {
                cnt++;
            }
            answer = Math.max(answer, cnt);
            if (answer == k + 1) break;
            sh.put(arr[lt], sh.get(arr[lt]) - 1);
            if (sh.get(arr[lt]) == 0) sh.remove(arr[lt]);
            lt++;
        }

        System.out.println(answer);

    }
}