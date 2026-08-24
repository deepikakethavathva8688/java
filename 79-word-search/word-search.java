class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: all characters matched
        if (index == word.length()) return true;

        // Out of bounds or mismatch
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark visited by temporarily changing the cell
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore neighbors (up, down, left, right)
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Restore the cell
        board[i][j] = temp;

        return found;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };

        System.out.println(sol.exist(board, "ABCCED")); // true
        System.out.println(sol.exist(board, "SEE"));    // true
        System.out.println(sol.exist(board, "ABCB"));   // false
    }
}
