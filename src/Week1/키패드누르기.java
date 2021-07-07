package Week1;

import java.util.*;

public class 키패드누르기 {
    public StringBuilder solution(int[] numbers, String hand) {
        Point rpos = new Point(3, 2);
        Point lpos = new Point(3, 0);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                lpos = new Point(numbers[i] / 3, 0);
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                rpos = new Point(numbers[i] / 3 - 1, 2);
            } else {
                if (numbers[i] == 0)
                    numbers[i] = 10;

                Point std = new Point(numbers[i] / 3, 1);

                int rdiff = Math.abs(std.x - rpos.x) + Math.abs(std.y - rpos.y);
                int ldiff = Math.abs(std.x - lpos.x) + Math.abs(std.y - lpos.y);
                if (rdiff > ldiff) {
                    sb.append("L");
                    lpos.x = numbers[i] / 3;
                    lpos.y = 1;
                } else if (rdiff < ldiff) {
                    sb.append("R");
                    rpos.x = numbers[i] / 3;
                    rpos.y = 1;
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        lpos.x = numbers[i] / 3;
                        lpos.y = 1;
                    } else {
                        sb.append("R");
                        rpos.x = numbers[i] / 3;
                        rpos.y = 1;
                    }
                }
            }
        }
        return sb;
    }
}

class Point{
    int x, y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

