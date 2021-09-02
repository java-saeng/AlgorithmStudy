package Week9;

class 멀쩡한사각형 {
    public long solution(int w, int h) {

        long ans = 0L;

        for(int i = 1; i < w; i++){
            ans += h*(long)i/w;
        }
        return ans * 2;
    }
}
