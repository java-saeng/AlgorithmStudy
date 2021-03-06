package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15663 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static Set<String> set = new LinkedHashSet<>();
    static int arr[];
    static int ar[] = new int[9];
    static boolean visit[] = new boolean[9];
    static int N, M;
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

        for (String s : set) {
            System.out.println(s);
        }

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
            if(visit[i]) continue;

            visit[i] = true;
            ar[cnt] = arr[i];
            dfs(cnt + 1);
            visit[i] = false;
        }
    }
}

/*
public class BOJ15663 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M;
    static int arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        arr = new int[10001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[atoi(st.nextToken())]++;
        }
        dfs("", 0);

        System.out.println(sb);
    }

    static void dfs(String str, int cnt) {
        if (cnt == M) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 1; i <= 10000; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                dfs(str + i + " ", cnt + 1);
                arr[i]++;
            }
        }
    }
}
*/
