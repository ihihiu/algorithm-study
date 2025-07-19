import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Character> key = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] str = input.split(" ");
            int location = -1;
            // 첫 글자 확인
            for (int j = 0; j < str.length; j++) {
                if (!key.contains(Character.toUpperCase(str[j].charAt(0)))) {
                    key.add(Character.toUpperCase(str[j].charAt(0)));
                    location = j;
                    break;
                }
            }
            if (location != -1) {
                for (int j = 0; j < str.length; j++) {
                    if (location == j) {
                        sb.append('[').append(str[j].charAt(0)).append(']');
                        for (int k = 1; k < str[j].length(); k++) {
                            sb.append(str[j].charAt(k));
                        }
                        sb.append(' ');
                    } else sb.append(str[j]).append(' ');
                }
                sb.append('\n');
            }
            else {
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) != ' ' && !key.contains(Character.toUpperCase(input.charAt(j)))) {
                        sb.append('[').append(input.charAt(j)).append(']');
                        key.add(Character.toUpperCase(input.charAt(j)));
                        sb.append(input.substring(j + 1));
                        break;
                    }
                    sb.append(input.charAt(j));
                }
                sb.append('\n');
            }


        }
        System.out.println(sb);
    }
}