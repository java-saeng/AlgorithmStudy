package Week10;

import java.io.*;
import java.util.*;

public class BOJ2805 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N; //나무 수
    static int M; //나무 길이
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = atoi(st.nextToken());
        }

        paraSearch();
    }

    //target은 높이를 의미함
    static boolean possible(long target) {
        long hei = 0L;

        for (int i = 0; i < N; i++) {
            if(A[i] > target){
                hei += A[i] - target;
            }
        }

        return hei >= M;
    }

    static void paraSearch() {
        long s = 0, e = 1000000000, rel = 0;

        while (s <= e) {
            long mid = (s + e) / 2;

            if (possible(mid)) {
                rel = mid;
                s = mid + 1;
            }
            else e = mid - 1;
        }
        System.out.println(rel);
    }
}

/**
 * 적어도 M미터 이상의 나무를 가져가기 위해 설정할 수 있는 높이의 최댓값
 * -> 높이가 h일 때, M미터 이상이 되나?
 */
