package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int arr[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        arr = new int[N + 1];
        visit = new boolean[N+1];

        dfs(1, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            arr[cnt] = i;
            dfs(i, cnt + 1);
            visit[i] = false;
        }
    }
}
