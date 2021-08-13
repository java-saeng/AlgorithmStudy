package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static boolean visit[];
    static int arr[];
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        visit = new boolean[N + 1];
        arr = new int[N + 1];

        dfs(0);

        System.out.println(sb);
    }

    static void dfs(int count) {

        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            arr[count] = i;
            dfs(count + 1);
            visit[i] = false;
        }
    }
}