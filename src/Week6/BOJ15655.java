package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15655 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int arr[];
    static int ar[] = new int[9];
    static boolean visit[] = new boolean[9];
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = atoi(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ar[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            ar[count] = arr[i];
            dfs(i, count + 1);
            visit[i] = false;
        }
    }
}
