package Week6;

import java.io.*;
import java.util.*;

public class BOJ15664 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static Set<String> set = new LinkedHashSet<>();
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

        dfs(0, 0);

        for (String s : set) {
            System.out.println(s);
        }
    }

    static void dfs(int start, int cnt) {
        if (cnt == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                str += ar[i] + " ";
            }
            set.add(str);
            return;
        }

        for (int i = start; i < N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            ar[cnt] = arr[i];
            dfs(i, cnt + 1);
            visit[i] = false;
        }
    }
}
