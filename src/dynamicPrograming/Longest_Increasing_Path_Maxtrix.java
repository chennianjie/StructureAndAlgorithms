package dynamicPrograming;


/**
 * 找到二维矩阵中的最长递增路径，从一个点出发可以上下左右方向走，但是下一点的值必须大于当前节点值
 */
public class Longest_Increasing_Path_Maxtrix {



    public static int longestPath(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col<matrix[0].length; col++) {
                max= Math.max(max, process(matrix, row, col));
            }
        }
        return max;
    }

    /**
     * 确定好一个点，求从这个点出发的最长路径
     * @param matrix
     * @param row
     * @param col
     * @return
     */
    public static int process(int[][] matrix, int row, int col) {
        int path = 1;//当前节点初始路径长

        //往左边走
        //条件：1.不越界  2.值递增
        if (col > 0 && matrix[row][col-1] > matrix[row][col]) {
            path = Math.max(process(matrix, row, col-1) + 1, path);
        }
        //往右边走
        if (col <= matrix[0].length - 2 && matrix[row][col+1] > matrix[row][col]) {
            path = Math.max(process(matrix, row, col+1) + 1, path);
        }
        //往上走
        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            path = Math.max(process(matrix, row - 1, col) + 1, path);
        }
        //往下走
        if (row <= matrix.length - 2 && matrix[row + 1][col] > matrix[row][col]) {
            path = Math.max(process(matrix, row + 1, col) + 1, path);
        }
        return path;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };
        System.out.println(Longest_Increasing_Path_Maxtrix.longestPath(matrix));
    }
}
