import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

        int lt = max;
        int rt = sum;
        int answer = Integer.MAX_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 1, money = mid;
            for (int i = 0; i < n; i++) {
                if (money < arr[i]){
                    cnt++;
                    money = mid;
                }
                money -= arr[i];
            }
            if (cnt <= m) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }
}