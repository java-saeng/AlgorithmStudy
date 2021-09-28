package Week11_2;

import java.util.*;

class 거리두기확인하기 {
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,1,-1};
    int idx = 0;
    int answer[] = new int[5];
    public int[] solution(String[][] places) {
        String arr[][] = new String[5][5];

        for(int i = 0; i < 5; i++){
            String s[] = places[i];
            for(int m = 0; m < 5; m++){
                for(int n = 0; n < 5; n++){
                    arr[m][n] = s[m].charAt(n)+"";
                }
            }
            answer[idx++] = bfs(arr);
        }

        return answer;
    }

    static int bfs(String A[][]){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(A[i][j].equals("P")){
                    Queue<Point> q = new ArrayDeque<>();
                    q.offer(new Point(i,j,0));

                    boolean visit[][] = new boolean[5][5];
                    visit[i][j] = true;

                    while(!q.isEmpty()){
                        Point p = q.poll();

                        if(p.times == 3) continue;

                        if(p.times >= 1 && A[p.x][p.y].equals("P")) return 0;

                        for(int k = 0; k < 4; k++){
                            int X = p.x + dx[k];
                            int Y = p.y + dy[k];

                            if(!isRangeTrue(X, Y)) continue;
                            if(visit[X][Y]) continue;
                            if(A[X][Y].equals("X")) continue;

                            q.offer(new Point(X, Y, p.times + 1));
                            visit[X][Y] = true;
                        }
                    }
                }
            }
        }
        return 1;
    }

    static boolean isRangeTrue(int x, int y){
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    static class Point{
        int x, y, times;

        Point(int x, int y, int times){
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }
}
