class Solution {
    public int maxDistance(List<List<Integer>> arrays) {

        int minValue = arrays.get(0).get(0);
        int maxValue = arrays.get(0).get(arrays.get(0).size() - 1);

        int answer = 0;

        for (int i = 1; i < arrays.size(); i++) {

            List<Integer> current = arrays.get(i);

            int currentMin = current.get(0);
            int currentMax = current.get(current.size() - 1);

            answer = Math.max(answer,
                    Math.max(currentMax - minValue,
                             maxValue - currentMin));

            minValue = Math.min(minValue, currentMin);
            maxValue = Math.max(maxValue, currentMax);
        }

        return answer;
    }
}