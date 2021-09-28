package Week11_2;

import java.util.*;

public class 수식최대화 {
    static long atoi(String str) {
        return Long.parseLong(str);
    }

    static ArrayList<String> al = new ArrayList<>();
    static long max;

    public static void main(String[] args) {
        System.out.println(solution("100-200*300-500+20"));
    }
    static long solution(String expression) {
        StringTokenizer st1 = new StringTokenizer(expression, "-*+");
        StringTokenizer st2 = new StringTokenizer(expression, "0123456789");

        while (st2.hasMoreTokens()) {
            al.add(st1.nextToken());
            al.add(st2.nextToken());
        }
        al.add(st1.nextToken());

        cal("+", "*", "-");
        cal("+", "-", "*");
        cal("-", "+", "*");
        cal("-", "*", "+");
        cal("*", "+", "-");
        cal("*", "-", "+");


        return max;
    }
    static void cal(String fir, String sec, String thi){
        ArrayList<String> copy = new ArrayList<>();

        for(String s : al) copy.add(s);

        while(copy.size() != 1){
            for(int i = 0; i < copy.size(); i++){
                String s = copy.get(i);
                if(s.equals(fir)){
                    copy.set(i-1, op(atoi(copy.get(i-1)),atoi(copy.get(i+1)),copy.get(i)));
                    copy.remove(i);
                    copy.remove(i);
                    i--;
                }
            }
            for(int i = 0; i < copy.size(); i++){
                String s = copy.get(i);
                if(s.equals(sec)){
                    copy.set(i-1, op(atoi(copy.get(i-1)),atoi(copy.get(i+1)),copy.get(i)));
                    copy.remove(i);
                    copy.remove(i);
                    i--;
                }
            }
            for(int i = 0; i < copy.size(); i++){
                String s = copy.get(i);
                if(s.equals(thi)){
                    copy.set(i-1, op(atoi(copy.get(i-1)),atoi(copy.get(i+1)),copy.get(i)));
                    copy.remove(i);
                    copy.remove(i);
                    i--;
                }
            }
        }
        long n = Math.abs(atoi(copy.get(0)));
        max = Math.max(n, max);
    }
    static String op(long num1, long num2, String op){
        if(op.equals("*")) return num1 * num2 + "";
        else if(op.equals("+")) return num1 + num2 + "";
        return num1 - num2 + "";
    }
}
