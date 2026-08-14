import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;
        
        while (left <= right && top <= bottom) {
            // Fill top row
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;
            
            // Fill right column
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;
            
            // Fill bottom row
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }
            
            // Fill left column
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        
        return matrix;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] result1 = sol.generateMatrix(3);
        System.out.println(Arrays.deepToString(result1));
        // [[1, 2, 3], [8, 9, 4], [7, 6, 5]]
        
        int[][] result2 = sol.generateMatrix(1);
        System.out.println(Arrays.deepToString(result2));
        // [[1]]
    }
}
