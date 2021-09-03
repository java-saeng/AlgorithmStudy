package Week9;

import java.io.*;
import java.util.*;

public class BOJ5557 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = atoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[N];
        long dp[][] = new long[N][21];

        for (int i = 0; i < N; i++) {
            arr[i] = atoi(st.nextToken());
        }

        dp[0][arr[0]] = 1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] > 0) {
                    if(isRangeTrue(j + arr[i])) dp[i][j + arr[i]] += dp[i - 1][j];
                    if(isRangeTrue(j - arr[i])) dp[i][j - arr[i]] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N - 2][arr[N - 1]]);
    }

    static boolean isRangeTrue(int x) {
        return x >= 0 && x <= 20;
    }
}
