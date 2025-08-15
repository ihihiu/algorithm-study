import java.io.*;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] ch = new int[100001];

        long answer = 0;
        int cnt = 0;
        int lt = 0;
        for (int rt = 0; rt < N; rt++) {
            ch[arr[rt]]++;

            while (ch[arr[rt]] > 1) {
                ch[arr[lt]]--;
                lt++;
            }

            answer += rt - lt + 1;

        }

        System.out.println(answer);

    }
}

