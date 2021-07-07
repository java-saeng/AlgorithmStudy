package Week1;

//BOJ 10866 덱

import java.util.*;
import java.io.*;

public class BOJ10866 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    static Deque<Integer> dq = new ArrayDeque<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test = atoi(st.nextToken());

        while(test-- > 0){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str){
                case "push_front":
                    push_front(atoi(st.nextToken()));
                    break;
                case "push_back":
                    push_back(atoi(st.nextToken()));
                    break;
                case "pop_front":
                    sb.append(pop_front() + "\n");
                    break;
                case "pop_back":
                    sb.append(pop_back() + "\n");
                    break;
                case "size":
                    sb.append(size() + "\n");
                    break;
                case "empty":
                    sb.append(empty() + "\n");
                    break;
                case "front":
                    sb.append(front() + "\n");
                    break;
                case "back":
                    sb.append(back()+ "\n");
                    break;
            }
        }
        System.out.print(sb);
    }

    static void push_front(int element){
        dq.addFirst(element);
    }

    static void push_back(int element){
        dq.addLast(element);
    }

    static int pop_front(){
        if(dq.size() == 0)
            return -1;
        int value = dq.pollFirst();
        return value;
    }

    static int pop_back(){
        if(dq.size() == 0)
            return -1;
        int value = dq.pollLast();
        return value;
    }

    static int size(){
        return dq.size();
    }

    static int empty(){
        if(dq.size() == 0)
            return 1;
        else
            return 0;
    }

    static int front(){
        if(dq.size() == 0)
            return -1;
        int value = dq.peekFirst();
        return value;
    }

    static int back(){
        if(dq.size() == 0)
            return -1;
        int value = dq.peekLast();
        return value;
    }
}
