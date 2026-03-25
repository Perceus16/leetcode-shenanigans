class Solution {
    public int maxProfit(int[] prices) {
        List<Integer> forw = new ArrayList<>();
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0 ; i < prices.length ; i++){
            minSoFar = Math.min(minSoFar , prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minSoFar);
            forw.add(maxProfit);
        }
        int maxSoFar = Integer.MIN_VALUE;
        maxProfit = 0;
        for (int i = prices.length - 1; i >= 0; i--) {
            maxSoFar = Math.max(maxSoFar, prices[i]);
            maxProfit = Math.max(maxProfit, forw.get(i) + maxSoFar - prices[i]);
        }
        return maxProfit;
    }
}