package Week10;

import java.io.*;
import java.util.*;

public class BOJ1654 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int K; //가지고 있는 랜선
    static int N; //만들어야하는 랜선의 개수
    static int a[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = atoi(st.nextToken());
        N = atoi(st.nextToken());
        a = new int[K];

        for (int i = 0; i < K; i++) {
            a[i] = atoi(br.readLine());
        }

        paraSearch();

    }

    static boolean possible(long target) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += a[i] / target;
        }

        return cnt >= N;
        /*
        cnt가 N보다 크거나 같다 -> 길이를 늘려야함
        -> 숫자를 크게해야한다 -> 그것 중에 제일 오른쪽에 있는 것
         */
    }

    static void paraSearch() {
        long s = 0, e = Integer.MAX_VALUE, rel = 0;

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
 * 랜선 N개를 만들 때, 최대 랜선의 길이.
 * -> 랜선의 길이가 h일 때, 랜선 N개 이상을 만족하느냐?
 */