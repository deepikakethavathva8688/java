class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        
        // Build run-length list: each entry = {char('0' or '1' as int), length}
        List<int[]> runs = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) j++;
            runs.add(new int[]{s.charAt(i) - '0', j - i});
            i = j;
        }
        
        int totalOnes = 0;
        for (int k = 0; k < n; k++) {
            if (s.charAt(k) == '1') totalOnes++;
        }
        
        int maxGain = 0;
        // Only consider "interior" runs (not first, not last)
        for (int k = 1; k < runs.size() - 1; k++) {
            if (runs.get(k)[0] == 1) { // a 1-block with 0-blocks on both sides
                int gain = runs.get(k - 1)[1] + runs.get(k + 1)[1];
                maxGain = Math.max(maxGain, gain);
            }
        }
        
        return totalOnes + maxGain;
    }
}