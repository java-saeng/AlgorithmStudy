package Week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13397 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }

    static int N; //
    static int M; //구간의 개수
    static int A[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = atoi(st.nextToken());
        M = atoi(st.nextToken());

        A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = atoi(st.nextToken());
        }

        paraSearch();
    }

    //target은 여기서 최대값 - 최소값
    static boolean possible(int target) {
        int cnt = 1, max = 0, min = 10001;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);

            if(max - min > target){
                cnt++;
                max = A[i];
                min = A[i];
            }
        }
        return cnt <= M;
    }

    static void paraSearch() {
        int s = 0, e = 10000, rel = 0;

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
