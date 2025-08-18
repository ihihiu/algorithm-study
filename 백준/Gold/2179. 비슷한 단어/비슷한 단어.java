import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();

        }
        int w1 = -1, w2 = -1;
        int max = -1;

        for (int i = 0; i < N - 1; i++) {
            String s1 = strs[i];
            for (int j = i + 1; j < N; j++) {
                int cnt = 0;
                String s2 = strs[j];
                cnt = check(s1, s2);
                if (cnt > max) {
                    w1 = i;
                    w2 = j;
                    max = cnt;
                }
            }
        }
        System.out.println(strs[w1]);
        System.out.println(strs[w2]);
    }



    static int check(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) == s2.charAt(i)) cnt++;
            else break;
        }
        return cnt;
    }
}

