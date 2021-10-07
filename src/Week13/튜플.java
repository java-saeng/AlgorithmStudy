package Week13;

import java.util.*;

class 튜플 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public ArrayList<Integer> solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        int possible[] = new int[100001];
        ArrayList<String> al = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(s, "{}");

        while(st.hasMoreTokens()){
            String s1 = st.nextToken();
            if(s1.equals(",")) continue;

            al.add(s1);
        }

        Collections.sort(al, (o1, o2)->{
            return o1.length() - o2.length();
        });

        for(String s2 : al){
            st = new StringTokenizer(s2, ",");

            while(st.hasMoreTokens()){
                int num = atoi(st.nextToken());
                if(possible[num] > 0) continue;
                possible[num]++;
                answer.add(num);
            }
        }

        return answer;
    }
}
