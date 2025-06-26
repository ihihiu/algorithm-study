import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> sh = new HashMap<>();

        int max = 0;
        for (int i = 0; i < X; i++) {
            max += arr[i];
        }
        int lt = 0, now = max;
        sh.put(max, sh.getOrDefault(max, 0) + 1);

        for (int rt = X; rt < N; rt++) {
            now -= arr[lt++];
            now += arr[rt];
            sh.put(now, sh.getOrDefault(now, 0) + 1);
            max = Math.max(max, now);
        }

        if (max == 0) System.out.println("SAD");
        else System.out.println(max + "\n" + sh.get(max));
    }
}