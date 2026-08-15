import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // Build list of numbers [1..n]
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        // Precompute factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }
        
        // Convert k to 0-based index
        k--;
        
        StringBuilder result = new StringBuilder();
        
        // Build permutation
        for (int i = n; i >= 1; i--) {
            int index = k / fact[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= fact[i - 1];
        }
        
        return result.toString();
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getPermutation(3, 3)); // Output: "213"
        System.out.println(sol.getPermutation(4, 9)); // Output: "2314"
        System.out.println(sol.getPermutation(3, 1)); // Output: "123"
    }
}
