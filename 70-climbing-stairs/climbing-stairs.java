class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int first = 1;  // f(1)
        int second = 2; // f(2)
        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(2)); // Output: 2
        System.out.println(sol.climbStairs(3)); // Output: 3
        System.out.println(sol.climbStairs(5)); // Output: 8
    }
}
