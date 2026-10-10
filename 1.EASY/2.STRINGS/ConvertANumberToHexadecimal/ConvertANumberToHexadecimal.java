// ============================ FINAL DESTINATION ============================

// RANK 1: Bit Manipulation + StringBuilder — O(1) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public String toHex(int num) {

        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        char[] hex = "0123456789abcdef".toCharArray();

        // int has 32 bits, so hexadecimal representation
        // needs at most 8 digits.
        for (int i = 0; i < 8; i++) {

            int digit = num & 15;   // Get last 4 bits

            result.append(hex[digit]);

            num = num >>> 4;        // Remove last 4 bits

            if (num == 0) {
                break;
            }
        }

        return result.reverse().toString();
    }
}

// RANK 2: Bit Manipulation + Character Conversion — O(1) TIME, O(1) SPACE — Alternative
// class Solution {
//     public String toHex(int num) {
//
//         if (num == 0) {
//             return "0";
//         }
//
//         StringBuilder result = new StringBuilder();
//
//         while (num != 0) {
//
//             int digit = num & 15;
//
//             if (digit < 10) {
//                 result.append((char) ('0' + digit));
//             } else {
//                 result.append((char) ('a' + digit - 10));
//             }
//
//             num = num >>> 4;
//         }
//
//         return result.reverse().toString();
//     }
// }


// RANK 3: Repeated Division by 16 — O(1) TIME, O(1) SPACE — Mathematical / Traditional
// class Solution {
//     public String toHex(int num) {
//
//         if (num == 0) {
//             return "0";
//         }
//
//         long value = num;
//
//         // Convert negative number to its 32-bit unsigned value.
//         if (value < 0) {
//             value += (1L << 32);
//         }
//
//         StringBuilder result = new StringBuilder();
//
//         char[] hex = "0123456789abcdef".toCharArray();
//
//         while (value > 0) {
//
//             int digit = (int) (value % 16);
//
//             result.append(hex[digit]);
//
//             value /= 16;
//         }
//
//         return result.reverse().toString();
//     }
// }

// Driver code to test the Solution class
public class ConvertANumberToHexadecimal {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int num1 = 26;

        System.out.println(solution.toHex(num1));
        // Answer: "1a"


        // Test Case 2
        int num2 = 10;

        System.out.println(solution.toHex(num2));
        // Answer: "a"


        // Test Case 3
        int num3 = 0;

        System.out.println(solution.toHex(num3));
        // Answer: "0"


        // Test Case 4
        int num4 = -1;

        System.out.println(solution.toHex(num4));
        // Answer: "ffffffff"


        // Test Case 5
        int num5 = 16;

        System.out.println(solution.toHex(num5));
        // Answer: "10"


        // Test Case 6
        int num6 = 255;

        System.out.println(solution.toHex(num6));
        // Answer: "ff"


        // Test Case 7
        int num7 = -26;

        System.out.println(solution.toHex(num7));
        // Answer: "ffffffe6"
    }
}
