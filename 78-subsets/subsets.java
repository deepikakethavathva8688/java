import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        // Add the current subset
        result.add(new ArrayList<>(temp));

        // Explore further elements
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);              // include nums[i]
            backtrack(result, temp, nums, i + 1); // recurse
            temp.remove(temp.size() - 1);   // backtrack (remove last element)
        }
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {1, 2, 3};
        System.out.println(sol.subsets(nums1));

        int[] nums2 = {0};
        System.out.println(sol.subsets(nums2));
    }
}
