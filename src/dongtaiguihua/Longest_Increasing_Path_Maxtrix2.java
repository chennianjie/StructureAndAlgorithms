package dongtaiguihua;

/**
 * 动态规划版本
 */
public class Longest_Increasing_Path_Maxtrix2 {

    public static int longestPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col<matrix[0].length; col++) {
                max= Math.max(max, process(matrix, dp, row, col));
                printArr(dp);
            }
        }
        return max;
    }

    public static void printArr(int[][] arr) {
        for (int[] a: arr) {
            for (int b : a) {
                System.out.print(b);
            }
            System.out.println();
        }
    }

    /**
     * 确定好一个点，求从这个点出发的最长路径
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    public static int process(int[][] matrix, int[][] dp, int row, int col) {

        if (dp[row][col] == 0) {
            dp[row][col] = 1;
            //往左边走
            //条件：1.不越界  2.值递增
            if (col > 0 && matrix[row][col-1] > matrix[row][col]) {
                dp[row][col] = Math.max(process(matrix, dp, row, col-1) + 1, dp[row][col]);
            }
            //往右边走
            if (col <= matrix[0].length - 2 && matrix[row][col+1] > matrix[row][col]) {
                dp[row][col] = Math.max(process(matrix, dp,  row, col+1) + 1, dp[row][col]);
            }
            //往上走
            if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
                dp[row][col] = Math.max(process(matrix, dp, row - 1, col) + 1, dp[row][col]);
            }
            //往下走
            if (row <= matrix.length - 2 && matrix[row + 1][col] > matrix[row][col]) {
                dp[row][col] = Math.max(process(matrix, dp, row + 1, col) + 1, dp[row][col]);
            }
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(Longest_Increasing_Path_Maxtrix2.longestPath(matrix));
    }
}
