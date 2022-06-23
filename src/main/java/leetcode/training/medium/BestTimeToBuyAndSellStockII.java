package leetcode.training.medium;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStockII {

  public int maxProfit(int[] prices) {
    int profit = 0;
    Integer stockPrice = null;

    for (int i = 0; i < prices.length - 1; i++) {
      if (stockPrice == null) {
        if (prices[i] < prices[i + 1]) stockPrice = prices[i];
      } else if (prices[i] > prices[i + 1]) {
        profit += prices[i] - stockPrice;
        stockPrice = null;
      }
    }
    return stockPrice == null ? profit : profit + prices[prices.length - 1] - stockPrice;
  }
}
