package printMatrix;

public class ZigZagPrintMatrix {

    public static void printLevel(int[][] m, int col1, int row1, int col2, int row2, boolean fromUp){
        //如果fromUp为true从左下往右上打印
        if (fromUp){
            while (row1 <= row2) {
                System.out.print(m[row2--][col2++] + " ");
            }
        } else {
            while (row1 <= row2) {
                System.out.print(m[row1++][col1--] + " ");
            }
        }
    }

    public static void zigZagMatrixPrint(int[][] matrix){
        int col1 = 0;
        int row1 = 0;
        int col2 = 0;
        int row2 = 0;
        int endC = matrix[0].length - 1;
        int endR = matrix.length - 1;
        boolean fromUp = false;
        while (row1 <= endR) {
            printLevel(matrix, col1, row1, col2, row2, fromUp);
            //这里的语句1和语句2不可以交换顺序，如果交换语句2对col1的值变换会影响语句1的判断
            row1 = col1 == endC ? row1+1 : row1;//语句1
            col1 = col1 == endC ? col1 : col1+1;//语句2

            col2 = row2 == endR ? col2+1 : col2;
            row2 = row2 == endR ? row2 : row2+1;
            fromUp = !fromUp;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10,11,12 } };
        zigZagMatrixPrint(matrix);
    }
}
