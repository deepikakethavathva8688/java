import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words.length == 0)
            return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen)
            return result;

        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Sliding window
        for (int i = 0; i < wordLen; i++) {

            int left = i;
            int count = 0;

            HashMap<String, Integer> window = new HashMap<>();

            for (int j = i; j + wordLen <= s.length(); j += wordLen) {

                String word = s.substring(j, j + wordLen);

                if (map.containsKey(word)) {

                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > map.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);

                        window.put(leftWord, window.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {

                        result.add(left);

                        String leftWord = s.substring(left, left + wordLen);

                        window.put(leftWord, window.get(leftWord) - 1);

                        left += wordLen;
                        count--;
                    }

                } else {

                    window.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }
}