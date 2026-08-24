class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 2; // index where next valid element will be placed

        for (int i = 2; i < nums.length; i++) {
            // Only allow element if it's not equal to nums[k-2]
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,1,1,2,2,3};
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("k = " + k1);
        for (int i = 0; i < k1; i++) System.out.print(nums1[i] + " ");
        System.out.println();

        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("k = " + k2);
        for (int i = 0; i < k2; i++) System.out.print(nums2[i] + " ");
    }
}
