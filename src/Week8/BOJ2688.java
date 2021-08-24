package Week8;

import java.io.*;
import java.util.*;

public class BOJ2688 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long dp[][] = new long[65][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int k = 2; k < 65; k++) {
            for (int i = 0; i < 10; i++) {
                for (int j = i; j < 10; j++) {
                    dp[k][i] += dp[k-1][j];
                }
            }
        }

        int test = atoi(br.readLine());

        while (test-- > 0) {
            int N = atoi(br.readLine());

            long sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += dp[N][i];
            }

            System.out.println(sum);
        }
    }
}
