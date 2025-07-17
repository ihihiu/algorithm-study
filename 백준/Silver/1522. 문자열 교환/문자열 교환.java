import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();

        int aCnt = 0;
        for (char ch : str.toCharArray()) {
            if (ch == 'a') {
                aCnt++;
            }
        }

        if (aCnt == 0 || aCnt == N) {
            System.out.println(0);
            return;
        }

        String s = str + str;
        char[] arr = s.toCharArray();

        int answer = Integer.MAX_VALUE;
        int bCnt = 0;

        for (int i = 0; i < aCnt; i++) {
            if (arr[i] == 'b') bCnt++;
        }
        answer = bCnt;

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] == 'b') bCnt--;
            if (arr[i + aCnt - 1] == 'b') bCnt++;
            answer = Math.min(answer, bCnt);
        }

        System.out.println(answer);

    }
}