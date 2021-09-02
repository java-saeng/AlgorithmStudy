package Week8;

import java.util.*;

class 문자열압축 {
    public int solution(String s) {
        int len = s.length();
        int answer = len;

        if(len == 1) return 1;

        for(int i = 1; i <= len / 2; i++){
            int cnt = 1;
            String rel = "";
            String now = "", next = "";
            for(int j = 0; j <= len / i; j++){

                int start = i * j;
                int end = i * (j + 1) > len ? len : i * (j + 1);

                now = next;
                next = s.substring(start, end);

                if(now.equals(next)){
                    cnt++;
                }
                else{
                    if(cnt > 1){
                        rel += cnt + now;
                    }
                    else{
                        rel += now;
                    }
                    cnt = 1;
                }
            }

            // 나누어 떨어지지 않을 경우
            // 뒤에 마지막 남은 것들을 더해줌
            rel += next;
            answer = Math.min(answer, rel.length());
        }
        return answer;
    }
}
