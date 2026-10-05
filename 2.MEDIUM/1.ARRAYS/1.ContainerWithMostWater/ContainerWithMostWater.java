// ============================ FINAL DESTINATION ============================

// RANK 1: Two Pointers — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int maxWater = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);

            int currentArea = width * minHeight;
            maxWater = Math.max(maxWater, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxWater;
    }
}

// RANK 2: Brute Force — O(n²) TIME, O(1) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int maxArea(int[] height) {
//         int maxWater = 0;
//
//         for (int i = 0; i < height.length; i++) {
//             for (int j = i + 1; j < height.length; j++) {
//
//                 int width = j - i;
//                 int currentHeight = Math.min(height[i], height[j]);
//                 int currentArea = width * currentHeight;
//
//                 maxWater = Math.max(maxWater, currentArea);
//             }
//         }
//
//         return maxWater;
//     }
// }

// Driver code to test the Solution class
public class ContainerWithMostWater {
    public static void main(String[] args) {

        Solution s = new Solution();

        // Test Case 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(s.maxArea(height1));
        // Answer: 49


        // Test Case 2
        int[] height2 = {1, 1};
        System.out.println(s.maxArea(height2));
        // Answer: 1


        // Test Case 3
        int[] height3 = {4, 3, 2, 1, 4};
        System.out.println(s.maxArea(height3));
        // Answer: 16


        // Test Case 4
        int[] height4 = {1, 2, 1};
        System.out.println(s.maxArea(height4));
        // Answer: 2


        // Test Case 5
        int[] height5 = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(s.maxArea(height5));
        // Answer: 17
    }
}