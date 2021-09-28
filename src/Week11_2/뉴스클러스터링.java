package Week11_2;

import java.util.*;

class 뉴스클러스터링 {
    ArrayList<String> a1 = new ArrayList<>();
    ArrayList<String> a2 = new ArrayList<>();
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i < str1.length()-1; i++){
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i+1);

            if(possible(ch1, ch2)) a1.add(""+ch1+ch2);
        }

        for(int i = 0; i < str2.length()-1; i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i+1);

            if(possible(ch1, ch2)) a2.add(""+ch1+ch2);
        }

        if(a1.size() == 0 && a2.size() == 0) return 65536;


        boolean visit[] = new boolean[a2.size()];
        int kyu = 0;
        int cha = 0;
        for(int i = 0; i < a1.size(); i++){
            for(int j = 0; j < a2.size(); j++){
                if(visit[j]) continue;

                if(a1.get(i).equals(a2.get(j))){
                    kyu++;
                    visit[j] = true;
                    break;
                }
            }
        }
        cha = a1.size() + a2.size() - kyu;

        double answer = (double)kyu / cha;

        int ans = (int)(answer * 65536);

        return ans;
    }


    static boolean possible(char ch1, char ch2){
        if( (ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')) return true;
        return false;
    }
}