import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] ch;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        ch = new boolean[N + 1];

        dfs(0, "");

    }

    static void dfs(int depth, String answer) {
        if (depth == M) {
            System.out.println(answer);
        } else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == false) {
                    ch[i] = true;
                    dfs(depth + 1, answer + i + " ");
                    ch[i] = false;
                }
            }
        }
    }
}