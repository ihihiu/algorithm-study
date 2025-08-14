import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String s = br.readLine();

        int len = s.length();
        StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            sb.append(c);

            if (sb.length() >= len &&
                    sb.substring(sb.length() - len).equals(s)) {
                sb.setLength(sb.length() - len);
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb);
    }
}

