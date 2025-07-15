import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int answer = 0;

        int red = 0;
        int blue = 0;

        int start = 0;
        int frontCnt = 1;

        for (int i = 1; i < N; i++) {
            if (arr[i] != arr[0]) {
                start = i;
                break;
            }
            frontCnt++;
        }

        int end = N - 1;
        int rearCnt = 1;

        if (start != N - 1) {
            for (int i = N - 2; i >= 0; i--) {
                if (arr[N - 1] != arr[i]) {
                    end = i;
                    break;
                }
                rearCnt++;
            }
        }

        if (arr[0] == arr[N - 1]) {
            if (arr[0] == 'R') {
                red += Math.min(frontCnt, rearCnt);
            } else {
                blue += Math.min(frontCnt, rearCnt);
            }
        }


        for (int i = start; i <= end; i++) {
            if (arr[i] == 'R') red++;
            else blue++;
        }

        answer = Math.min(red, blue);
        System.out.println(answer);
    }
}