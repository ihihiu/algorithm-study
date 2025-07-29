import java.io.*;
import java.util.*;

class Main{
    static int N;
    static int[] arr;
    static boolean[] ch;
    static List<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        ch = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()) - 1;
        }

        answer = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            ch[i] = true;
            dfs(i, i);
            ch[i] = false;
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i) + 1);
        }
    }

    public static void dfs(int x, int start) {
        if (ch[arr[x]] == false) {
            ch[arr[x]] = true;
            dfs(arr[x], start);
            ch[arr[x]] = false;
        }
        if (arr[x] == start) answer.add(start);
    }
}

