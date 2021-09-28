package Week11_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11441 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = atoi(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            A[i] = A[i] + A[i - 1];
        }

        M = atoi(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            sb.append(preFixSum(s1, s2)).append("\n");
        }

        System.out.print(sb);
    }

    static int preFixSum(int x, int y) {
        return A[y] - A[x - 1];
    }
}
