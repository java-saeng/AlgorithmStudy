package Week11_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1561 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int N, M, ans;
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            A[i] = atoi(st.nextToken());
        }

        if(N <= M) ans = N;
        else {
            N -= M;
            paraSearch();
        }

        System.out.println(ans);
    }

    //target은 시간을 의미함
    static boolean possible(long target) {
        long cnt = 0;

        for (int i = 0; i < M; i++) {
            cnt += target / A[i];
        }

        return cnt >= N;
    }

    //언제 이 인원이 다 타는지 최소 시간 구하기
    static void paraSearch() {
        long s = 1, e = 2000000000*10000L, rel = 0;

        while (s <= e) {
            long mid = (s + e) / 2;

            if (possible(mid)) {
                rel = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }

        findNum(rel);
    }

    static void findNum(long time) {
        //tiem - 1까지 몇 명이 탔는지 알기
         int presum = 0;

        for (int i = 0; i < M; i++) {
            presum += (time-1) / A[i];
        }

        //이게 time 때 타야하는 명수
        int nowsum = N - presum;

        for (int i = 0; i < M; i++) {
            if(time % A[i] == 0) nowsum--;

            if(nowsum == 0){
                ans = i + 1;
                return;
            }
        }

    }
}