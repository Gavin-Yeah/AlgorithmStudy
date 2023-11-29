package dynamicProgramming;

public class PrintEdge {
    // 回型打印
    public static void process(int[][] m) {
        int a = 0, b = 0;
        int c = m.length, d = m[0].length;
        while (a != c && b != d) {
            printEdge(m, a++, b++, c--, d--);
        }
    }

    public static void printEdge(int[][] m, int a, int b, int c, int d) {
        if (a == c) {
            for (int i = 0; i < d; i++) {
                System.out.println(m[a][i] + " ");
            }
        } else if (b == c) {
            for (int i = 0; i < c; i++) {
                System.out.println(m[i][b] + " ");
            }
        } else {
            int curC = b;
            int curR = a;
            while (curC != d) {
                System.out.println(m[curR][curC++] + " ");
            }
            while (curR != c) {
                System.out.println(m[curR++][curC] + " ");
            }
            while (curC != b) {
                System.out.println(m[curR][curC--] + " ");
            }
            while (curR != a) {
                System.out.println(m[curR--][curC] + " ");
            }
        }
    }
}
