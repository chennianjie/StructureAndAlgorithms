package test;

/**
 * 一个二维矩阵由0和1组成，求这个二维矩阵中有多少个岛结构（由1上下左右连在一起即称为一个岛）
 * 思路：遍历二维数组，每当遍历到1时候，就用一个感染函数，将这个位置的周围的1都感染成2，然后res++，当所有1被感染成2时结果就出来了
 */
public class IsIsland {

    public static int isIsland(int[][] matrix) {
        int res = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                  res++;
                  //感染
                  infect(matrix, row, col);
                }
            }
        }
        return res;
    }

    private static void infect(int[][] matrix, int row, int col) {
        if (row >= matrix.length || row < 0 || col >= matrix[0].length || col < 0 || matrix[row][col] != 1) {
            return;
        }
        matrix[row][col] = 2;
        infect(matrix, row+1, col);
        infect(matrix, row, col+1);
        infect(matrix, row-1, col);
        infect(matrix, row, col-1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,0,1,0,0,0,1},
                          {1,0,1,1,0,0,0,1}};
        int island = IsIsland.isIsland(matrix);
        System.out.println(island);
    }
}
