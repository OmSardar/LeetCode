// ============================ FINAL DESTINATION ============================

// RANK 1: Character Array + Reverse Every 2k Block — O(n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i += 2 * k) {

            int left = i;
            int right = Math.min(i + k - 1, chars.length - 1);

            while (left < right) {

                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return new String(chars);
    }
}


// RANK 2: StringBuilder + Character Array — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND

// class Solution {
//     public String reverseStr(String s, int k) {
//
//         StringBuilder result = new StringBuilder(s);
//
//         for (int i = 0; i < s.length(); i += 2 * k) {
//
//             int left = i;
//             int right = Math.min(i + k - 1, s.length() - 1);
//
//             while (left < right) {
//
//                 char temp = result.charAt(left);
//
//                 result.setCharAt(left, result.charAt(right));
//                 result.setCharAt(right, temp);
//
//                 left++;
//                 right--;
//             }
//         }
//
//         return result.toString();
//     }
// }


// RANK 3: Recursive Reversal — O(n) TIME, O(n) SPACE — RECURSIVE / ALTERNATIVE

// class Solution {
//     public String reverseStr(String s, int k) {
//
//         char[] chars = s.toCharArray();
//
//         reverseBlocks(chars, 0, k);
//
//         return new String(chars);
//     }
//
//     private void reverseBlocks(char[] chars, int start, int k) {
//
//         if (start >= chars.length) {
//             return;
//         }
//
//         int left = start;
//         int right = Math.min(start + k - 1, chars.length - 1);
//
//         while (left < right) {
//
//             char temp = chars[left];
//             chars[left] = chars[right];
//             chars[right] = temp;
//
//             left++;
//             right--;
//         }
//
//         reverseBlocks(chars, start + 2 * k, k);
//     }
// }




// Driver code to test the Solution class
public class ReverseStringII {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
            solution.reverseStr("abcdefg", 2)
        ); // Answer: bacdfeg

        // Test Case 2
        System.out.println(
            solution.reverseStr("abcdefghijk", 3)
        ); // Answer: cbadefihgjk

        // Test Case 3
        System.out.println(
            solution.reverseStr("abcdef", 2)
        ); // Answer: bacdfe

        // Test Case 4
        System.out.println(
            solution.reverseStr("a", 2)
        ); // Answer: a

        // Test Case 5
        System.out.println(
            solution.reverseStr("abcdefghi", 3)
        ); // Answer: cbadefihg
    }
}