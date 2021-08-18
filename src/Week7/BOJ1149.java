package Week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = atoi(br.readLine());

        int arr[][] = new int[N + 1][3];
        int dp[][] = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = atoi(st.nextToken());
            }
        }

        dp[2][0] = arr[2][0] + Math.min(arr[1][1], arr[1][2]);
        dp[2][1] = arr[2][1] + Math.min(arr[1][0], arr[1][2]);
        dp[2][2] = arr[2][2] + Math.min(arr[1][0], arr[1][1]);

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }
        sb.append(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
        System.out.println(sb);
        }
    }
