import java.io.*;
import java.util.*;

public class Main{
    static HashSet<Integer> set;
    static StringBuilder sb = new StringBuilder();
    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("all")) all();
            else if (cmd.equals("empty")) empty();
            else {
                int num = Integer.parseInt(st.nextToken());
                if (cmd.equals("add")) add(num);
                else if (cmd.equals("remove")) remove(num);
                else if (cmd.equals("check")) check(num);
                else if (cmd.equals("toggle")) toggle(num);
            }

        }
        System.out.println(sb);
    }

    static void add(int num) {
        set.add(num);
    }

    static void check(int num) {
        if (set.contains(num)) sb.append("1\n");
        else sb.append("0\n");
    }

    static void remove(int num) {
        set.remove(num);
    }

    static void toggle(int num) {
        if (set.contains(num)) set.remove(num);
        else set.add(num);
    }

    static void all() {
        for (int i = 1; i <= 20; i++) set.add(i);
    }

    static void empty() {
        set.clear();
    }
}