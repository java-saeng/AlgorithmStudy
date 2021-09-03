package Week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1495 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, base, limit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        base = atoi(st.nextToken());
        limit = atoi(st.nextToken());

        int arr[] = new int[N + 1];
        boolean dp[][] = new boolean[N + 1][limit + 1];

        dp[0][base] = true; //제일 처음은 무조건 됨

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = atoi(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= limit; j++) {
                //i-1번째의 볼륨이 되는지 확인
                if (dp[i - 1][j]) {
                    if(isRangeTrue(j + arr[i])) dp[i][j+arr[i]] = true;
                    if(isRangeTrue(j - arr[i])) dp[i][j-arr[i]] = true;
                }
            }
        }

        //max가 갱신되지 않으면 -1
        int max = -1;
        for (int i = limit; i >= 0; i--) {
            if(dp[N][i]){
                max = i;
                break;
            }
        }

        System.out.println(max);
    }

    static boolean isRangeTrue(int x) {
        return x >= 0 && x <= limit;
    }
}
