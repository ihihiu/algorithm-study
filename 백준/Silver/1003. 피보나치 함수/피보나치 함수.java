import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] count0 = new int[41];
        int[] count1 = new int[41];

        count0[0] = 1;
        count0[1] = 0;

        count1[0] = 0;
        count1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            count0[i] = count0[i - 1] + count0[i - 2];
            count1[i] = count1[i - 1] + count1[i - 2];
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(count0[N] + " " + count1[N]);
        }

    }

}