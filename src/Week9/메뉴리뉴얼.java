package Week9;

import java.util.*;
import java.io.*;

public class 메뉴리뉴얼 {
    static HashMap<String, Integer> hm = new HashMap<>();
    static char s[];
    static ArrayList<String> ans = new ArrayList<>();
    static ArrayList<String> al = new ArrayList<>();
    public static void main(String[] args) {
        String orders[] = {"XYZ", "XWY", "WXA"};
        int course[] = {2,3,4};

        String[] solution = solution(orders, course);

        Arrays.sort(solution);

        for (String s : solution) {
            System.out.println(s);
        }

    }



    static String[] solution(String[] orders, int[] course) {

        //각 order마다 course가 2일 떄, 3일 때, 4일때를 뽑아
        for (int i = 0; i < course.length; i++) {
            hm = new HashMap<>(); //course가 2일 때, 3일 때 따로 생각
            for (int j = 0; j < orders.length; j++) {
                s = new char[course[i]];
                dfs(0, 0, course[i], orders[j]);
            }
            find();
        }

        String ar[] = ans.toArray(new String[ans.size()]);

        return ar;
    }

    //각 course만큼 조합을 구해라.
    static void dfs(int start, int cnt, int limit, String orders){
        if(cnt > limit) return;

        if (cnt == limit) {

            //이미 바꿔놨으니까 당연히 s[0]는 계속해서 w가 들어가지
//            Arrays.sort(s);

            char ch[] = new char[s.length];

            for (int i = 0; i < s.length; i++) {
                ch[i] = s[i];
            }

            Arrays.sort(ch);
//            String str = new String(s);

            String str = "";

            for (char c : ch) {
                str += c;
            }

//            System.out.println(str);
            if (hm.get(str) == null) {
                hm.put(str, 1);
            } else {
                hm.put(str, hm.get(str) + 1);
            }

            return;
        }

        for (int i = start; i < orders.length(); i++) {
            s[cnt] = orders.charAt(i);
            dfs(i+1, cnt + 1, limit, orders);
        }
    }

    static void find () {
        int max = 0;
        for (String key : hm.keySet()) {
            int value = hm.get(key);
            if (value >= max) {
                max = value;
            }
        }

        if (max < 2) return;

        for (String key : hm.keySet()) {
            int value = hm.get(key);
            if (value == max) {
                ans.add(key);
            }
        }
    }

}

