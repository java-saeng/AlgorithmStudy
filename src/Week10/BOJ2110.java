package Week10;

import java.io.*;
import java.util.*;

public class BOJ2110 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N; //집 개수
    static int C; //공유기
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        C = atoi(st.nextToken());

        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = atoi(br.readLine());
        }

        Arrays.sort(A);

        paraSearch();
    }

    //target은 거리를 뜻함
    static boolean possible(int target) {
        int last = A[0];
        int cnt = 1;
        for (int i = 1; i < N; i++) {
            if(A[i] - last >= target){
                cnt++;
                last = A[i];
            }
        }
        //cnt가 C보다 커 -> 설치한 공유기 개수가 더많다
        //-> 거리를 더 늘려야함 -> 최대 거리니까 그 중에 제일 오른쪽 값
        return cnt >= C;
    }

    static void paraSearch() {
        int s = 0, e = 1000000000, rel = 0;

        while (s <= e) {
            int mid = (s + e) / 2;
            if(possible(mid)){
                rel = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
        System.out.println(rel);
    }
}

/**
 * C개의 공유기를 N개의 집에 설치해서 거리가 최대
 * -> 거리가 n일 때, C개의 공유기를 설치할 수 있나?
 */