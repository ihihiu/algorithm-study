import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[W];
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            int lt = 0, rt = 0;
            for (int j = 0; j < i; j++) {
                lt = Math.max(lt, arr[j]);
            }
            for (int j = i + 1; j < W; j++) {
                rt = Math.max(rt, arr[j]);
            }
            if (arr[i] < lt && arr[i] < rt) {
                answer += Math.min(lt, rt) - arr[i];
            }
        }
        System.out.println(answer);
    }
}