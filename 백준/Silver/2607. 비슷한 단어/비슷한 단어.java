import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] first = new int[26];

        char[] f = br.readLine().toCharArray();

        for (char x : f) {
            first[x - 'A'] += 1;
        }

        int answer = 0;
        for (int i = 1; i < N; i++) {
            char[] now = br.readLine().toCharArray();
            int[] tmp = first.clone();
            for (char x : now) {
                tmp[x - 'A']--;
            }
            int plus = 0, minus = 0;
            for (int diff : tmp) {
                if (diff == 1) plus++;
                else if (diff == -1) minus++;
                else if (Math.abs(diff) > 1) {
                    plus = 10;
                    break;
                }
            }
            if ((plus == 0 && minus == 0) ||
                (plus == 1 && minus == 0) ||
                (plus == 0 && minus == 1) ||
                (plus == 1 && minus == 1)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}