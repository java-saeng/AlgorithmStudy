package Week7;

import java.util.*;

class 카카오프렌드컬러링북 {
    static boolean visit[][];
    static int row, col;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    public int[] solution(int m, int n, int[][] picture) {
        visit = new boolean[m][n];
        row = m;
        col = n;

        int component = 0;
        int area = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visit[i][j] && picture[i][j] != 0){
                    area = Math.max(bfs(i, j, picture), area);
                    component++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = component;
        answer[1] = area;

        return answer;
    }
    static int bfs(int x, int y, int[][] picture){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visit[x][y] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int X = q.poll();
            int Y = q.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int dX = X + dx[i];
                int dY = Y + dy[i];

                if(!isRangeTrue(dX,dY)) continue;
                if(picture[dX][dY] != picture[X][Y]) continue;
                if(picture[dX][dY] == 0) continue;
                if(visit[dX][dY]) continue;

                q.offer(dX);
                q.offer(dY);
                visit[dX][dY] = true;
            }
        }
        return cnt;
    }

    static boolean isRangeTrue(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
