package Week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2022 {
    static double atoi(String str) {
        return Double.parseDouble(str);
    }
    static double x, y, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = atoi(st.nextToken());
        y = atoi(st.nextToken());
        c = atoi(st.nextToken());

        binarySearch();
    }

    static boolean findC(double d) {
        double X = Math.sqrt(x * x - d * d);
        double Y = Math.sqrt(y * y - d * d);

        double temp = (X * Y) / (X + Y);

        return temp >= c;
    }

    static void binarySearch() {
        double s = 0, e = Math.min(x, y), rel = 0;

        while (s <= e) {
            double mid = (s + e) / 2;

            if(findC(mid)){
                rel = mid;
                s = mid + 0.001;
            }
            else e = mid - 0.001;
        }
        System.out.println(String.format("%.3f", rel));
    }
}
