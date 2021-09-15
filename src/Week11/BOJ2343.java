package Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2343 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    static int N; //강의 수
    static int M; //블루레이 개수
    static int A[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = atoi(st.nextToken());
        }

        paraSearch();
    }

    //target은 여기서 블루레이 크기
    static boolean possible(int target) {
        int cnt = 1, sum = 0;

        for (int i = 1; i <= N; i++) {
            sum += A[i];

            if (sum > target) {
                cnt++;
                sum = A[i];
            }
        }
        return cnt <= M;
    }

    static void paraSearch() {
        int s = 1, e = 1000000000, rel = 0;
        for (int i = 1; i <= N; i++) s = Math.max(s, A[i]);

        while (s <= e) {
            int mid = (s + e) / 2;

            if (possible(mid)) {
                rel = mid;
                e = mid - 1;
            }
            else s = mid + 1;
        }

        System.out.println(rel);
    }
}
