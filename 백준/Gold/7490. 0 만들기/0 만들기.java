import java.io.*;
import java.util.*;

class Main{
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, "1");
            System.out.println();
        }
    }

    public static void dfs(int depth, String answer) {
        if (depth == N) {
            if (evaluate(answer.replace(" ", "")) == 0) {
                System.out.println(answer);
            }
            return;
        } else {
            dfs(depth + 1, answer + " " + (depth + 1));
            dfs(depth + 1,  answer + "+" + (depth + 1));
            dfs(depth + 1, answer + "-" + (depth + 1));
        }
    }

    public static int evaluate(String s) {
        int sum = 0;
        int num = 0;
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                if (op == '+') sum += num;
                else if (op == '-') sum -= num;

                op = ch;
                num = 0;
            }
        }
        return sum;
    }
}

