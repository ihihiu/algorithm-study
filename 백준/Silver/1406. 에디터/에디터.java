import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int idx = sb.length();

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            String cmd = line[0];
            if (cmd.equals("L")) {
                if (idx != 0) idx--;
            } else if (cmd.equals("D")) {
                if (idx != sb.length()) idx++;
            } else if (cmd.equals("B")) {
                if (idx != 0) {
                    sb.deleteCharAt(idx - 1);
                    idx--;
                }
            } else {
                String str = line[1];
                sb.insert(idx, str);
                idx += str.length();
            }
        }
        System.out.println(sb);
    }
}