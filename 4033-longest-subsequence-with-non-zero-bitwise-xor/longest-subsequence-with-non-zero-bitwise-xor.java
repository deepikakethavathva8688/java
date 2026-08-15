class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }
        if( xor != 0) {
                return nums.length;
            }
        boolean allZero = true;
        for(int num : nums) {
            // if(int num : nums) {
                if(num != 0){
                    allZero = false;
                    break;
                }
            }
        return allZero ? 0 : nums.length - 1;
        
    }
}