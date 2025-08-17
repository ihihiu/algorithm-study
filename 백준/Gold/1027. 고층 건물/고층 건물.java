import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            double maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (arr[j] - arr[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    cnt++;
                }
            }

            double minSlope = Double.POSITIVE_INFINITY;
            for (int j = i - 1; j >=0; j--) {
                double slope = (double) (arr[i] - arr[j]) / (i - j);
                if (slope < minSlope) {
                    minSlope = slope;
                    cnt++;
                }
            }

            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

}

