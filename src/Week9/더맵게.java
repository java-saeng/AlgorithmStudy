package Week9;

import java.util.*;

class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cnt = 0;
        for(int i = 0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(pq.size() > 1 && pq.peek() < K){
            int s1 = pq.poll();
            int s2 = pq.poll();

            cnt++;
            int sum = s1 + 2 * s2;

            pq.offer(sum);
        }

        if(pq.size() >= 1 && pq.peek() >= K) return cnt;
        return -1;
    }
}
