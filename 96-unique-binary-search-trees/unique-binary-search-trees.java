class Solution {
    public int numTrees(int n) {
        // dp[i] = number of unique BSTs with i nodes
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty tree
        dp[1] = 1; // single node tree

        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                int left = root - 1;       // nodes in left subtree
                int right = nodes - root;  // nodes in right subtree
                dp[nodes] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTrees(3)); // Output: 5
        System.out.println(sol.numTrees(1)); // Output: 1
    }
}
