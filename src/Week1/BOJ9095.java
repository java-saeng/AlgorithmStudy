package Week1;

import java.util.*;

public class BOJ9095 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        int []dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;

        for(int i = 5; i < 11; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        while(test-- > 0) {
            int num = sc.nextInt();
            System.out.println(dp[num]);
        }
    }
}
