package Week10;

import java.util.*;

class 괄호변환 {
    public String solution(String p) {

        if(iscorrect(p)) return p;

        String answer = recur(p);
        return answer;
    }
    static String recur(String w){
        if(w.length() == 0 ) return "";

        int num1 = 0, num2 = 0;
        String u = "", v = "";
        for(int i = 0; i < w.length(); i++){
            char ch = w.charAt(i);
            if(ch == '(') num1++;
            else num2++;

            if(num1 == num2){
                u = w.substring(0, i+1);
                v = w.substring(i+1, w.length());
                break;
            }
        }

        String str = "";
        if(iscorrect(u)){
            u = u + recur(v);
            return u;
        }
        else{
            str = "(" + recur(v) + ")";

            for(int i = 1; i < u.length() - 1; i++){
                char ch = u.charAt(i);
                if(ch == '(') ch = ')';
                else ch = '(';

                str += ch;
            }
        }
        return str;
    }
    static boolean iscorrect(String s){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }
        return true;
    }
}