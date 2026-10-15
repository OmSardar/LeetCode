// ============================ FINAL DESTINATION ============================

// RANK 1: One Pass — O(n) TIME, O(1) SPACE — Most Efficient

class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int zeros = 0;
        int maxScore = 0;

        // Initially, count all ones in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        // Move the split from left to right.
        // The last character must remain in the right part.
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones--;
            }

            maxScore = Math.max(maxScore, zeros + ones);
        }

        return maxScore;
    }
}


// RANK 2: Prefix Counting + Suffix Counting — O(n) TIME, O(n) SPACE
// class Solution {
//     public int maxScore(String s) {
//         int n = s.length();
//         int[] prefixZeros = new int[n];
//         int[] suffixOnes = new int[n];

//         for (int i = 0; i < n; i++) {
//             prefixZeros[i] = (i > 0 ? prefixZeros[i - 1] : 0)
//                     + (s.charAt(i) == '0' ? 1 : 0);
//         }

//         for (int i = n - 1; i >= 0; i--) {
//             suffixOnes[i] = (i < n - 1 ? suffixOnes[i + 1] : 0)
//                     + (s.charAt(i) == '1' ? 1 : 0);
//         }

//         int maxScore = 0;

//         for (int i = 0; i < n - 1; i++) {
//             maxScore = Math.max(
//                     maxScore,
//                     prefixZeros[i] + suffixOnes[i + 1]
//             );
//         }

//         return maxScore;
//     }
// }

// RANK 3: Brute Force — O(n²) TIME, O(1) EXTRA SPACE
// class Solution {
//     public int maxScore(String s) {
//         int maxScore = 0;

//         for (int i = 1; i < s.length(); i++) {
//             int zeros = 0;
//             int ones = 0;

//             for (int j = 0; j < i; j++) {
//                 if (s.charAt(j) == '0') {
//                     zeros++;
//                 }
//             }

//             for (int k = i; k < s.length(); k++) {
//                 if (s.charAt(k) == '1') {
//                     ones++;
//                 }
//             }
//             maxScore = Math.max(maxScore, zeros + ones);
//         }
//         return maxScore;
//     }
// }

// Driver code to test the Solution class
public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s1 = "011101";
        System.out.println(solution.maxScore(s1));
        // Answer: 5

        String s2 = "00111";
        System.out.println(solution.maxScore(s2));
        // Answer: 5

        String s3 = "1111";
        System.out.println(solution.maxScore(s3));
        // Answer: 3

        String s4 = "0000";
        System.out.println(solution.maxScore(s4));
        // Answer: 3

        String s5 = "10";
        System.out.println(solution.maxScore(s5));
        // Answer: 0

        String s6 = "110011";
        System.out.println(solution.maxScore(s6));
        // Answer: 4
    }
}