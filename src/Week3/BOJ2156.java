package Week3;

import java.io.*;
import java.util.*;

public class BOJ2156 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = atoi(br.readLine());

        int arr[] = new int[N + 1];
        int dp[][] = new int[N + 1][2];

        for (int i = 1; i <= N; i++) arr[i] = atoi(br.readLine());

        dp[1][0] = arr[1];
        dp[1][1] = 0;

        if(N >= 2) {
            dp[2][0] = arr[1] + arr[2];
            dp[2][1] = arr[1];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(arr[i - 1] + dp[i - 2][1], dp[i - 1][1]) + arr[i];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0]);
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));

    }
}
