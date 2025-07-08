import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(arr, (a, b) -> b[1] - a[1]);

        int answer = arr[0][1];
        int left = arr[0][0];
        int right = arr[0][0] + 1;

        for (int i = 1; i < N; i++) {
            if (arr[i][0] < left) {
                answer += (left - arr[i][0]) * arr[i][1];
                left = arr[i][0];
            }
            if (arr[i][0] >= right) {
                answer += (arr[i][0] + 1 - right) * arr[i][1];
                right = arr[i][0] + 1;
            }
        }

        System.out.println(answer);



    }
}