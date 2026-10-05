// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Divide & Conquer Bit Manipulation — O(1), O(1) — BEST / MOST EFFICIENT
// class Solution {
//     public int reverseBits(int n) {
//         int x = n;

//         x = ((x >>> 1) & 0x55555555) | ((x & 0x55555555) << 1);
//         x = ((x >>> 2) & 0x33333333) | ((x & 0x33333333) << 2);
//         x = ((x >>> 4) & 0x0f0f0f0f) | ((x & 0x0f0f0f0f) << 4);
//         x = ((x >>> 8) & 0x00ff00ff) | ((x & 0x00ff00ff) << 8);
//         x = (x >>> 16) | (x << 16);

//         return x;
//     }
// }

// RANK 2: Bit-by-Bit Iterative — O(32) = O(1), O(1) — SIMPLE / MOST READABLE
class Solution {
    public int reverseBits(int n) {

        int number = n;
        int reversed = 0;

        for (int i = 0; i < 32; i++) {

            int lastBit = number & 1;

            reversed = reversed << 1;
            reversed = reversed | lastBit;

            number = number >>> 1;
        }

        return reversed;
    }
}

// RANK 3: Two-Pointer Bit Swap — O(16) = O(1), O(1) — EFFICIENT, BUT MORE COMPLEX
// class Solution {
//      public int reverseBits(int n) {
//         int x = n;
//         for (int i = 0; i < 16; i++) {
//             int left = (x >>> i) & 1;
//             int right = (x >>> (31 - i)) & 1;
//             if (left != right) {
//                 x ^= (1 << i);
//                 x ^= (1 << (31 - i));
//             }
//         }
//         return x;
//     }
// }


// Driver code to test the Solution class
public class ReverseBits {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // TEST CASE 1
        // Input: 43261596
        // Binary: 00000010100101000001111010011100
        // Output: 964176192
        System.out.println(obj.reverseBits(43261596));

        // TEST CASE 2
        // Input: 0
        // Binary: 00000000000000000000000000000000
        // Output: 0
        System.out.println(obj.reverseBits(0));

        // TEST CASE 3
        // Input: 1
        // Binary: 00000000000000000000000000000001
        // Output: -2147483648
        System.out.println(obj.reverseBits(1));

        // TEST CASE 4
        // Input: 2
        // Binary: 00000000000000000000000000000010
        // Output: 1073741824
        System.out.println(obj.reverseBits(2));

        // TEST CASE 5
        // Input: 3
        // Binary: 00000000000000000000000000000011
        // Output: -1073741824
        System.out.println(obj.reverseBits(3));

        // TEST CASE 6
        // Input: -1
        // Binary: 11111111111111111111111111111111
        // Output: -1
        System.out.println(obj.reverseBits(-1));
    }
}