package Week13;

import java.util.*;

class 프린터 {
    static Queue<Print> q = new ArrayDeque<>();
    public int solution(int[] priorities, int location) {
        int answer = 0;

        for(int i = 0; i < priorities.length; i++){
            q.offer(new Print(i, priorities[i]));
        }

        while(!q.isEmpty()){
            int max = findMax();

            Print p = q.poll();

            if(p.pri == max){
                answer++;
                if(p.idx == location) break;
            }
            else{
                q.offer(p);
            }

        }

        return answer;
    }

    static int findMax(){
        int max = Integer.MIN_VALUE;

        for(Print p : q){
            max = Math.max(max, p.pri);
        }

        return max;
    }


}

class Print{
    int idx, pri;

    Print(int idx, int pri){
        this.idx = idx;
        this.pri = pri;
    }
}
