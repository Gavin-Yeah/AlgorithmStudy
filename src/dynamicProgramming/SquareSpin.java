package dynamicProgramming;

/**
 * SquareSpin
 */
public class SquareSpin {

    public static void squareSpin(int[][]m){
        int a = 0, b = 0, c = m.length, d = m[0].length;
        while(a<c){
            spinEdge(m, a++, b++, c--, d--);
        }
    }
    public static void spinEdge(int[][]m, int a, int b, int c, int d){
        int temp;
        //左上[a][b+1] 右上[a+i][d] 右下[c][d-i] 左下[c-i][b]
        for(int i = 0; i< d-b; i++){
            temp = m[a][b+i];
            m[a][b+i] = m[c - i][b];
            m[c-i][b] = m[c][d-i];
            m[c][d-i] = m[a+i][d];
            m[a+i][d] = temp; 
        }
    }
}