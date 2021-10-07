package Week13;

import java.util.*;

class 전화번호목록 {
    static HashMap<String, String> hm = new HashMap<>();
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (o1, o2)->{
            return o1.length() - o2.length();
        });

        for(String s : phone_book){
            if(find(s)) {
                hm.put(s, s);
            }
            else{
                answer = false;
                break;
            }
        }

        return answer;
    }

    static boolean find(String str){

        for(int i = 0; i < str.length(); i++){
            if(hm.get(str.substring(0, i)) != null) return false;
        }

        return true;
    }
}
