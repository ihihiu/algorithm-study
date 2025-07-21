import java.io.*;
import java.util.*;

class Main{
    public static String S, T;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        dfs(T);
        System.out.println(answer);

    }

    public static void dfs(String tmp) {
        int len = tmp.length();
        if (len == S.length()) {
            if (tmp.equals(S)) {
                answer = 1;
            }
            return;
        }
        if (tmp.charAt(len - 1) == 'A') {
            dfs(tmp.substring(0, len - 1));
        }
        if (tmp.charAt(0) == 'B') {
            dfs(new StringBuilder(tmp.substring(1)).reverse().toString());
        }
    }
}