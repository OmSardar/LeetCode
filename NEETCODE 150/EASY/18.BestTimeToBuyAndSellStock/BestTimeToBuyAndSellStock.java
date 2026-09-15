// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Optimal One-Pass / Greedy — O(n), O(1) — BEST / MOST EFFICIENT
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}

// RANK 2: Dynamic Programming (State Compression) — O(n), O(1)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int hold = -prices[0]; 
//         int notHold = 0;       

//         for (int price : prices) {
//             hold = Math.max(hold, -price);
//             notHold = Math.max(notHold, hold + price);
//         }
//         return notHold;
//     }
// }

// RANK 3: Sliding Window / Two Pointers — O(n), O(1)
// class Solution {
//     public int maxProfit(int[] prices) {
//         int left = 0;
//         int right = 1;
//         int maxProfit = 0;

//         while (right < prices.length) {
//             if (prices[right] > prices[left]) {
//                 maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
//             } else {
//                 left = right;
//             }
//             right++;
//         }

//         return maxProfit;
//     }
// }

// RANK 4: Prefix Minimum Array — O(n), O(n)
// class Solution {
//     public int maxProfit(int[] prices) {
//        int n = prices.length;
//        int minLeft[] = new int[n];
//        minLeft[0]= prices[0];
//        for(int i=1; i<n; i++){
//         minLeft[i] = Math.min(minLeft[i-1], prices[i]);
//        }
//        int maxProfit = 0;
//        for(int i=0; i<n; i++){
//         maxProfit = Math.max(maxProfit, prices[i] - minLeft[i]);
//        }
//        return maxProfit;
//     }
// }

// RANK 5: Brute Force — O(n²), O(1) — WORST / NOT RECOMMENDED
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         for(int i=0; i<prices.length; i++){
//             for(int j=i+1; j<prices.length; j++){
//                 if (prices[j] > prices[i]) {
//                 maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
//                 }
//             }
//         }
//         return maxProfit;
//     }
// }

// Driver code to test the Solution class
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test Case 1: " + solution.maxProfit(prices1));
        // Output: Test Case 1: 5

        // Test Case 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Test Case 2: " + solution.maxProfit(prices2));
        // Output: Test Case 2: 0

        // Test Case 3
        int[] prices3 = {1, 2};
        System.out.println("Test Case 3: " + solution.maxProfit(prices3));
        // Output: Test Case 3: 1

        // Test Case 4
        int[] prices4 = {2, 4, 1};
        System.out.println("Test Case 4: " + solution.maxProfit(prices4));
        // Output: Test Case 4: 2
    }
}