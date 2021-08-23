package Week2;

// 출처 : https://programmers.co.kr/learn/challenges

import java.util.*;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        String answer = "";

        for(int i = 0; i < participant.length; i++){
            String s = participant[i];
            if(map.containsKey(s)){
                int value = map.get(s);
                value++;
                map.put(s,value);
            }
            else{
                map.put(s, 1);
            }
        }

        for(int i = 0; i < completion.length; i++){
            String s = completion[i];
            int value = map.get(s);
            value--;
            map.put(s,value);
        }

        for(String key : map.keySet()){
            if(map.get(key) != 0)
                answer = key;
        }

        return answer;
    }
}