import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0, rt = N - 1;
        int ansLt = arr[0], ansRt = arr[N - 1];
        int min = Integer.MAX_VALUE;
        while (lt < rt) {
            int diff = Math.abs(arr[lt] + arr[rt]);
            if (diff < min) {
                ansLt = arr[lt];
                ansRt = arr[rt];
                min = diff;
            }
            if (arr[lt] + arr[rt] < 0) {
                lt++;
            } else rt--;
        }
        System.out.println(ansLt + " " + ansRt);
    }
}

