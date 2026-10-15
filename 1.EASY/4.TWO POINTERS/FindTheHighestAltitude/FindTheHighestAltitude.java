// ============================ FINAL DESTINATION ============================

// RANK 1: Running Sum — O(n) TIME, O(1) SPACE — Most Efficient

class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int g : gain) {
            altitude += g;
            highest = Math.max(highest, altitude);
        }

        return highest;
    }
}

// RANK 2: Prefix Sum Array — O(n) TIME, O(n) SPACE — Preserves All Altitudes
// class Solution {
//     public int largestAltitude(int[] gain) {
//         int[] sum = new int[gain.length + 1];

//         int largestAltitude = 0;

//         for (int i = 0; i < gain.length; i++) {
//             sum[i + 1] = sum[i] + gain[i];
//             largestAltitude = Math.max(largestAltitude, sum[i + 1]);
//         }

//         return largestAltitude;
//     }
// }

// RANK 3: Brute Force — O(n²) TIME, O(n) SPACE — Basic / Educational
// class Solution {
//     public int largestAltitude(int[] gain) {
//         int n = gain.length;
//         int highest = 0;
//
//         for (int i = 0; i < n; i++) {
//             int altitude = 0;
//
//             for (int j = 0; j <= i; j++) {
//                 altitude += gain[j];
//             }
//
//             highest = Math.max(highest, altitude);
//         }
//
//         return highest;
//     }
// }

// Driver code to test the Solution class
public class FindTheHighestAltitude {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] gain1 = { -5, 1, 5, 0, -7 };
        System.out.println(solution.largestAltitude(gain1));
        // Answer: 1

        int[] gain2 = { -4, -3, -2, -1, 4, 3, 2 };
        System.out.println(solution.largestAltitude(gain2));
        // Answer: 0

        int[] gain3 = { 1, 2, 3, 4 };
        System.out.println(solution.largestAltitude(gain3));
        // Answer: 10

        int[] gain4 = { 0, 0, 0 };
        System.out.println(solution.largestAltitude(gain4));
        // Answer: 0

        int[] gain5 = { -1, -2, -3 };
        System.out.println(solution.largestAltitude(gain5));
        // Answer: 0

        int[] gain6 = { 3, -2, 4, -1 };
        System.out.println(solution.largestAltitude(gain6));
        // Answer: 5
    }
}