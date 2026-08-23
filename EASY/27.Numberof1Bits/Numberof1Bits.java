// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Java Built-in `Integer.bitCount()` — O(1), O(1) — BEST PRACTICAL / MOST EFFICIENT
// class Solution {
//     public int hammingWeight(int n) {
//         return Integer.bitCount(n);
//     }
// }

// RANK 2: Brian Kernighan’s Algorithm — O(k), O(1) — BEST ALGORITHMIC / INTERVIEW METHOD
class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}

// RANK 3: Right Shift & Check Last Bit — O(32) = O(1), O(1) — SIMPLE / MOST READABLE
// class Solution {
//     public int hammingWeight(int n) {
//         int count = 0;
//         for (int i = 0; i < 32; i++) {
//             count += (n & 1);
//             n >>>= 1;
//         }
//         return count;
//     }
// }

// RANK 4: Convert to Binary String — O(32) = O(1), O(32) — SIMPLE, BUT EXTRA SPACE
// class Solution {
//     public int hammingWeight(int n) {
//         int count = 0;
//         String binary = Integer.toBinaryString(n);

//         for (char bit : binary.toCharArray()) {
//             if (bit == '1') {
//                 count++;
//             }
//         }

//         return count;
//     }
// }

// Driver code to test the Solution class
public class Numberof1Bits {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] testCases = { 11, 128, 7, 15, 16, 31 };

        for (int n : testCases) {
            int result = obj.hammingWeight(n);

            System.out.println("Input: " + n);
            System.out.println("Number of 1 bits: " + result);
            System.out.println("------------------------");
        }

        /*
        Answers:
        
        11  -> 1011   -> 3
        128 -> 10000000 -> 1
        7   -> 111    -> 3
        15  -> 1111   -> 4
        16  -> 10000  -> 1
        31  -> 11111  -> 5
        */
    }
}