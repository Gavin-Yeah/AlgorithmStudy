package dynamicProgramming;

public class Hano {
    public static void hano(int n) {
        if(n > 0){
            move(n, "left", "right", "mid");
        }
    }
    public static void move(int N, String from, String to, String other) {
        if(N == 1){
            System.out.println("Move 1 from " + from + " to " + to);
        }
        else {
            move(N - 1, from , other, to);
            System.out.println("Move " + N + " from " + from + " to " + to);
            move(N - 1, other, to, from);
        }
    }
    public static void main(String[] args) {
        hano(4);
    }
}
