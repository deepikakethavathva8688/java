class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums);
            return;
        }
        int min_index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = index + 1; i < n; i++) {
            if (nums[i] > nums[index]) {
                min = Math.min(min, nums[i]);
            }
            if (min == nums[i]) {
                min_index = i;
            }
        }
        swap(nums, min_index, index);
        Arrays.sort(nums, index + 1, n);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

}