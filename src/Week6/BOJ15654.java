package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15654 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static boolean visit[] = new boolean[9];
    static int arr[];
    static int ar[] = new int[9];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = atoi(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ar[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visit[i]) continue;

            ar[cnt] = arr[i];
            visit[i] = true;
            dfs(cnt + 1);
            visit[i] = false;
        }
    }
}
