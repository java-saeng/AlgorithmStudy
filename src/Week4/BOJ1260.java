package Week4;

import java.util.*;
import java.io.*;

public class BOJ1260 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N, M, start;
    static ArrayList<Integer>[] al;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        start = atoi(st.nextToken());

        al = new ArrayList[N+1];
        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            al[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            al[s1].add(s2);
            al[s2].add(s1);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(al[i]);
        }

        dfs(start);
        visit = new boolean[N + 1];
        sb.append("\n");
        bfs(start);

        System.out.println(sb);
    }

    static void dfs(int start) {
        visit[start] = true;
        sb.append(start).append(" ");
        for (int value : al[start]) {
            if(visit[value]) continue;

            dfs(value);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true; //중요
        while (!q.isEmpty()) {
            int value = q.poll();
            sb.append(value).append(" ");
            /////////////////////////////////////이 부분이 bfs 말할 때 주의할 곳
            for (int element : al[value]) {
                if(visit[element]) continue;

                q.offer(element);
                visit[element] = true; //중요
            }
        }
    }
}
