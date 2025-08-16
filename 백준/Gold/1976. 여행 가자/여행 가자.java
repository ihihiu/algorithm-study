import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int[][] relation = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(stringTokenizer.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        int[] route = new int[M];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(stringTokenizer.nextToken());
        }


        String answer = "YES";
        for (int i = 0; i < M - 1; i++) {
            int s = route[i] - 1;
            int e = route[i + 1] - 1;
            if (find(s) != find(e)) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa > pb) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }
}

