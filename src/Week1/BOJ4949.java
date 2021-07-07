package Week1;

import java.util.*;

public class BOJ4949 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack;
        while(true){
            String str = sc.nextLine();
            stack = new Stack<>();
            if(str.equals(".")) break;
            boolean flag = true;
            for(int i = 0; i < str.length(); i++){
                char ch1 = str.charAt(i);

                if(ch1 == '(' || ch1 == '['){
                    stack.push(ch1);
                }

                else if(ch1 == ')' || ch1 == ']') {
                    if (!stack.isEmpty() && ch1 == ')') {
                        if (stack.peek() == '(') stack.pop();
                        else flag = false;
                    }
                    else if(!stack.isEmpty() && ch1 == ']') {
                        if (stack.peek() == '[') stack.pop();
                        else flag = false;
                    }
                    else if(stack.isEmpty() && (ch1 == ')' || ch1 == ']')){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}

//public class Main {
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        Stack<Character> stack;
//        while(true){
//            String str = sc.nextLine();
//            stack = new Stack<>();
//            if(str.equals(".")) break;
//            boolean flag = true;
//            for(int i = 0; i < str.length(); i++){
//                char ch1 = str.charAt(i);
//
//                if(ch1 == '(' || ch1 == '['){
//                    stack.push(ch1);
//                }
//
//
//                if(!stack.isEmpty()) {
//                    if (ch1 == ')'){
//                        if(stack.peek() == '(') stack.pop();
//                        else flag = false;
//                    }
//
//                    if (ch1 == ']'){
//                        if(stack.peek() == '[') stack.pop();
//                        else flag = false;
//                    }
//                }
//
//                else{
//                    if(ch1 == ')' || ch1 == ']') {
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//            if(flag && stack.isEmpty())
//                System.out.println("yes");
//            else
//                System.out.println("no");
//        }
//    }
//}
