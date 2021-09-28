package Week11_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2003 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int A[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        pro();
    }

    static void pro() {
        int e = 0, sum = 0, cnt = 0;

        for (int s = 1; s <= N; s++) {
            sum -= A[s - 1];

            while (e + 1 <= N && sum < M) {
                sum += A[++e];
            }

            if(sum == M) cnt++;
        }
        System.out.println(cnt);
    }
}
