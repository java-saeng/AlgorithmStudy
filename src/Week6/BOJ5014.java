package Week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    static int limit, now, target, up, down;
    static int click = -1;
    static boolean visit[] = new boolean[1000001];
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        limit = atoi(st.nextToken());
        now = atoi(st.nextToken());
        target = atoi(st.nextToken());
        up = atoi(st.nextToken());
        down = atoi(st.nextToken());

        bfs(now);

        if(click == -1)
            System.out.println("use the stairs");
        else
            System.out.println(click);
    }

    static void bfs(int start) {
        Queue<Stair> q = new ArrayDeque<>();
        q.offer(new Stair(start , 0));
        while (!q.isEmpty()) {
            Stair st = q.poll();
            int count = st.cnt;

            if(st.x == target) {
                click = st.cnt;
                return;
            }

            int a = st.x + up;
            int b = st.x - down;

            if(isRangeTrue(a) && !visit[a]){
                q.offer(new Stair(a, count + 1));
                visit[a] = true;
            }

            if (isRangeTrue(b) && !visit[b]) {
                q.offer(new Stair(b, count + 1));
                visit[b] = true;
            }
        }
    }

    static boolean isRangeTrue(int x) {
        return x >= 1 && x <= limit;
    }
    static class Stair{
        int x, cnt;

        public Stair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
}