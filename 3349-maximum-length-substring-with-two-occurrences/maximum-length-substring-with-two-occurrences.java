import java.util.*;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLen = 0;
        
        // Frequency map for characters
        int[] freq = new int[26];
        
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            freq[c - 'a']++;
            
            // Shrink window if count exceeds 2
            while (freq[c - 'a'] > 2) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }
            
            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maximumLengthSubstring("bcbbbcba")); // Output: 4
        System.out.println(sol.maximumLengthSubstring("aaaa"));     // Output: 2
    }
}
