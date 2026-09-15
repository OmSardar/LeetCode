// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Iterative + StringBuilder + Reverse — O(log₍26₎ n), O(log₍26₎ n) — BEST PRACTICAL / RECOMMENDED
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;                 // important adjustment
            char ch = (char) ('A' + (columnNumber % 26));
            sb.append(ch);
            columnNumber /= 26;
        }

        return sb.reverse().toString();
    }
}

// RANK 2: Iterative + Char Array — O(log₍26₎ n), O(1) AUXILIARY SPACE — MOST SPACE EFFICIENT
// class Solution {
//     public String convertToTitle(int columnNumber) {
//         char[] arr = new char[10]; // max length < 10
//         int idx = 0;

//         while (columnNumber > 0) {
//             columnNumber--;
//             arr[idx++] = (char) ('A' + columnNumber % 26);
//             columnNumber /= 26;
//         }

//         StringBuilder sb = new StringBuilder();
//         for (int i = idx - 1; i >= 0; i--) {
//             sb.append(arr[i]);
//         }
//         return sb.toString();
//     }
// }


// RANK 3: Recursive Approach — O(log₍26₎ n), O(log₍26₎ n) — SIMPLE / ELEGANT
// class Solution {
//     public String convertToTitle(int columnNumber) {
//         if (columnNumber == 0) return "";

//         columnNumber--;
//         return convertToTitle(columnNumber / 26) + (char) ('A' + (columnNumber % 26));
//     }
// }

// RANK 4: Stack / Deque Logic — O(log₍26₎ n), O(log₍26₎ n) — CORRECT, BUT UNNECESSARY EXTRA STRUCTURE
// import java.util.ArrayDeque;
// import java.util.Deque;

// class Solution {
//     public String convertToTitle(int columnNumber) {
//         Deque<Character> stack = new ArrayDeque<>();

//         while (columnNumber > 0) {
//             columnNumber--;
//             stack.push((char) ('A' + columnNumber % 26));
//             columnNumber /= 26;
//         }

//         StringBuilder sb = new StringBuilder();
//         while (!stack.isEmpty()) {
//             sb.append(stack.pop());
//         }

//         return sb.toString();
//     }
// }

// Driver code to test the Solution class
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // TEST CASE 1
        // 1 → A
        System.out.println(obj.convertToTitle(1));
        // Output: A


        // TEST CASE 2
        // 26 → Z
        System.out.println(obj.convertToTitle(26));
        // Output: Z


        // TEST CASE 3
        // 27 → AA
        System.out.println(obj.convertToTitle(27));
        // Output: AA


        // TEST CASE 4
        // 28 → AB
        System.out.println(obj.convertToTitle(28));
        // Output: AB


        // TEST CASE 5
        // 52 → AZ
        System.out.println(obj.convertToTitle(52));
        // Output: AZ


        // TEST CASE 6
        // 53 → BA
        System.out.println(obj.convertToTitle(53));
        // Output: BA


        // TEST CASE 7
        // 701 → ZY
        System.out.println(obj.convertToTitle(701));
        // Output: ZY


        // TEST CASE 8
        // 702 → ZZ
        System.out.println(obj.convertToTitle(702));
        // Output: ZZ


        // TEST CASE 9
        // 703 → AAA
        System.out.println(obj.convertToTitle(703));
        // Output: AAA
    }
}