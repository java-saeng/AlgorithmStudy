package Week6;

import java.io.*;
import java.util.*;

public class BOJ15665 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static boolean visit[];
    static int ar[];
    static Set<String> set = new LinkedHashSet<>();
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        arr = new int[N];
        ar = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = atoi(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0);

        for (String s : set) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int cnt) {
        if (cnt == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                str += ar[i] + " ";
            }
            set.add(str);
            return;
        }

        for (int i = 0; i < N; i++) {
            ar[cnt] = arr[i];
            dfs(cnt + 1);
        }
    }
}
