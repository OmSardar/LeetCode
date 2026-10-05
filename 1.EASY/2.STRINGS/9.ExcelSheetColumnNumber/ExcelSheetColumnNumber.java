// ============================ FINAL DESTINATION ============================

// RANK 1: Iterative Base-26 Conversion — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST DIRECT
class Solution {
    public int titleToNumber(String columnTitle) {

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            int value = columnTitle.charAt(i) - 'A' + 1;

            result = result * 26 + value;
        }

        return result;
    }
}


// RANK 2: Character Array Traversal — O(n) TIME, O(n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public int titleToNumber(String columnTitle) {
//
//         char[] letters = columnTitle.toCharArray();
//         int result = 0;
//
//         for (char ch : letters) {
//             int value = ch - 'A' + 1;
//             result = result * 26 + value;
//         }
//
//         return result;
//     }
// }


// RANK 3: Recursive Base-26 Conversion — O(n) TIME, O(n) STACK SPACE — RECURSIVE / GOOD ALTERNATIVE
// class Solution {
//     public int titleToNumber(String columnTitle) {
//         return convert(columnTitle, 0);
//     }
//
//     private int convert(String s, int index) {
//
//         if (index == s.length()) {
//             return 0;
//         }
//
//         int value = s.charAt(index) - 'A' + 1;
//
//         return value * (int) Math.pow(26, s.length() - index - 1)
//              + convert(s, index + 1);
//     }
// }


// Driver code to test the Solution class
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {

        Solution s = new Solution();


        // Test Case 1
        String column1 = "A";
        System.out.println(s.titleToNumber(column1));
        // Answer: 1


        // Test Case 2
        String column2 = "B";
        System.out.println(s.titleToNumber(column2));
        // Answer: 2


        // Test Case 3
        String column3 = "Z";
        System.out.println(s.titleToNumber(column3));
        // Answer: 26


        // Test Case 4
        String column4 = "AA";
        System.out.println(s.titleToNumber(column4));
        // Answer: 27


        // Test Case 5
        String column5 = "AB";
        System.out.println(s.titleToNumber(column5));
        // Answer: 28


        // Test Case 6
        String column6 = "ZY";
        System.out.println(s.titleToNumber(column6));
        // Answer: 701


        // Test Case 7
        String column7 = "FXSHRXW";
        System.out.println(s.titleToNumber(column7));
        // Answer: 2147483647
    }
}