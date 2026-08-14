public class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Prefix sum matrix
        long[][] prefix = new long[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = grid[i - 1][j - 1] 
                             + prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1];
            }
        }
        
        int count = 0;
        // Check all submatrices starting at (0,0)
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (prefix[i][j] <= k) {
                    count++;
                }
            }
        }
        
        return count;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] grid1 = {{7,6,3},{6,6,1}};
        System.out.println(sol.countSubmatrices(grid1, 18)); // Output: 4
        
        int[][] grid2 = {{7,2,9},{1,5,0},{2,6,6}};
        System.out.println(sol.countSubmatrices(grid2, 20)); // Output: 6
    }
}
