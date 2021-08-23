package Week7;

// 출처 : https://programmers.co.kr/learn/challenges

import java.util.*;

class 짝지어제거하기 {
    public int solution(String s){
        int answer = -1;
        Stack<Character> stack = new Stack<>();

        char ch[] = new char[s.length()];

        for(int i = 0; i < s.length(); i++){
            ch[i] = s.charAt(i);
        }

        int idx = 0;
        while(idx != s.length()){
            if(stack.isEmpty()) {
                stack.push(ch[idx]);
                idx++;
            }
            else {
                if(stack.peek() == ch[idx]){
                    stack.pop();
                }
                else    {
                    stack.push(ch[idx]);
                }
                idx++;
            }
        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;

        return answer;
    }
}