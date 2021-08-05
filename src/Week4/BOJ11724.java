package Week4;

import java.util.*;
import java.io.*;

public class BOJ11724 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int arr[][];
    static boolean visit[];
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        int ans = 0;
        arr = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = atoi(st.nextToken());
            int s2 = atoi(st.nextToken());
            arr[s1][s2] = arr[s2][s1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visit[i]){
                bfs(i);
                ans++;
            }
        }

        System.out.println(ans);
    }
    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visit[start] = true; // 중요

        while (!q.isEmpty()) {
            int element = q.poll();

/*          위의 주석을 하지 않으면 시간초과가 난다.
            왜냐하면 큐에 1,2 번이 있고 1,2번 둘다 3번으로 갈 수 있따고하면
            1번을 poll해서 3번을 방문하더라도 3번을 방문표시 안했기 때문에
            2번노드가 3번을 방문하게 될 수 있다.*/
            for (int i = 1; i <= N; i++) {
                if(!visit[i] && arr[element][i] == 1){
                    q.offer(i);
                    visit[i] = true; // 중요
               }
            }
        }
    }
}
