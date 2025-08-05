import java.io.*;
import java.util.*;

class Main {
    static int N, answer;
    static int[][] teamwork;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;
        teamwork = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                teamwork[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ch = new boolean[N];
        ch[0] = true;

        dfs(1, 1);
        System.out.println(answer);

    }

    public static void dfs(int depth, int start) {
        if (depth == N / 2) {
            int trueTeam = 0;
            int falseTeam = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j) continue;
                    if (ch[i] && ch[j]) {
                        trueTeam += teamwork[i][j] + teamwork[j][i];
                    }
                    if (!ch[i] && !ch[j]) {
                        falseTeam += teamwork[i][j] + teamwork[j][i];
                    }
                }
            }
            answer = Math.min(answer, Math.abs(trueTeam - falseTeam));
        } else {
            for (int i = start; i < N; i++) {
                if (!ch[i]) {
                    ch[i] = true;
                    dfs(depth + 1, i + 1);
                    ch[i] = false;
                }
            }
        }
    }

}

