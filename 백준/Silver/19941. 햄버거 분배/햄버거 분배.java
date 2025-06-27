import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] arr = br.readLine().toCharArray();
        boolean[] ch = new boolean[N];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {
                boolean flag = false;
                for (int lt = Math.max(0, i - K); lt < i; lt++) {
                    if (arr[lt] == 'H' && ch[lt] == false) {
                        ch[lt] = true;
                        flag = true;
                        answer++;
                        break;
                    }
                }
                if (!flag) {
                    for (int rt = i + 1; rt < Math.min(i + 1 + K, N); rt++) {
                        if (arr[rt] == 'H' && ch[rt] == false) {
                            ch[rt] = true;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}