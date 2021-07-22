package Week3;

//BOJ 1541 잃어버린 괄호

import java.util.*;
import java.io.*;

public class BOJ1541 {
    static int atoi(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        ArrayList<String> al = new ArrayList<>();

        while (st.hasMoreTokens()) {
            al.add(st.nextToken());
        }

        st = new StringTokenizer(al.get(0), "+");

        int first = 0;

        while (st.hasMoreTokens()) {
            first += atoi(st.nextToken());
        }

        for (int i = 1; i < al.size(); i++) {
            st = new StringTokenizer(al.get(i), "+-");
            while (st.hasMoreTokens()) {
                first -= atoi(st.nextToken());
            }
        }

        System.out.println(first);
    }
}
