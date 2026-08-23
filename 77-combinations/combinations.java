import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if combination size == k
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try each number from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            current.add(i);                // choose
            backtrack(i + 1, n, k, current, result); // explore
            current.remove(current.size() - 1);      // un-choose (backtrack)
        }
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combine(4, 2)); // Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
        System.out.println(sol.combine(1, 1)); // Output: [[1]]
    }
}
