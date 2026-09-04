import java.util.*;

class Solution {
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        if (!haveSameChars(s1, s2)) return false;

        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) return memo.get(key);

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: no swap
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }
            // Case 2: swap
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean haveSameChars(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}
