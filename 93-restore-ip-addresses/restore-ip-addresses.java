import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        // If we already have 4 parts and consumed all digits → valid IP
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            // Skip invalid segments (leading zeros or >255)
            if ((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) {
                continue;
            }

            path.add(segment);
            backtrack(s, start + len, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.restoreIpAddresses("25525511135")); 
        // Output: [255.255.11.135, 255.255.111.35]

        System.out.println(sol.restoreIpAddresses("0000")); 
        // Output: [0.0.0.0]

        System.out.println(sol.restoreIpAddresses("101023")); 
        // Output: [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
    }
}
