package dynamicProgramming;

public class zigzag {
    public static void printMatrixZigzag(int[][]matrix){
        int Ar = 0, Ac = 0;
        int Br = 0, Bc = 0;
        int Endr = matrix.length - 1;
        int Endc = matrix[0].length - 1;
        boolean fromUp = false; 
        while(Ar != Endr + 1) {
            printLevel( matrix, Ar, Ac, Br, Bc, fromUp);
            Ar = Ac == Endc ? Ar + 1 : Ar;
            Ac = Ac == Endc ? Ac : Ac + 1;
            Bc = Br == Endr ? Bc + 1 : Bc;
            Br = Br == Endr ? Br : Br + 1;
            fromUp = !fromUp; 
            
        }

    }

    public static void printLevel(int[][] matrix, int Ar, int Ac, int Br, int Bc, boolean fromUp) {
            if(fromUp){
                while(Ar != Br + 1) {
                    System.out.print(matrix[Ar++][Ac--] + " ");
                }
            }else {
                while(Br != Ar - 1) {
                    System.out.print(matrix[Br--][Bc++] + " ");
                }
            }
    }
}
