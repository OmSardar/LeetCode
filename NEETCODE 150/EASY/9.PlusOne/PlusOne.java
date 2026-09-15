// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Simple Carry Method (BEST) — O(n), O(1)
class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}

// RANK 2: Recursive Carry Propagation — O(n), O(n)
// class Solution {
//     public int[] plusOne(int[] digits) {
//         return addOne(digits, digits.length - 1); 
//     }

//     private int[] addOne(int[] digits, int index) {
//         if (index < 0) {
//             int[] res = new int[digits.length + 1];
//             res[0] = 1;
//             return res;
//         }

//         if (digits[index] < 9) {
//             digits[index]++;
//             return digits;
//         }

//         digits[index] = 0;
//         return addOne(digits, index - 1);
//     }
// }

// RANK 3: Convert to List — O(n²), O(n)
// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public int[] plusOne(int[] digits) {
//         List<Integer> list = new ArrayList<>();
//         int carry = 1;
//         for (int i = digits.length - 1; i >= 0; i--) {
//             int sum = digits[i] + carry;
//             list.add(0, sum % 10);
//             carry = sum / 10;
//         }
//         if (carry > 0) {
//             list.add(0, carry);
//         }
//         int[] result = new int[list.size()];
//         for (int i = 0; i < list.size(); i++) {
//             result[i] = list.get(i);
//         }
//         return result;
//     }
// }

// RANK 4: Using BigInteger — O(n), O(n)
// import java.math.BigInteger;

// class Solution {
//     public int[] plusOne(int[] digits) {
//         StringBuilder sb = new StringBuilder();
//         for (int d : digits) {
//             sb.append(d);
//         }

//         BigInteger num = new BigInteger(sb.toString());
//         num = num.add(BigInteger.ONE);

//         String s = num.toString();
//         int result[] = new int[s.length()];

//         for (int i = 0; i < s.length(); i++) {
//             result[i] = s.charAt(i) - '0';
//         }
//         return result;
//     }
// }

//Driver code to test the Solution class
public class PlusOne {
    public static void main(String[] args) {
        Solution obj = new Solution();

        int[][] testCases = {
                { 1, 2, 3 },
                { 4, 3, 2, 1 },
                { 1, 2, 9 },
                { 9 },
                { 9, 9, 9 },
                { 2, 9, 9 },
                { 8, 9 },
                { 0 },
                { 1, 0, 0, 0 }
        };

        for (int[] digits : testCases) {
            System.out.print("Input : ");
            System.out.print("[");
            for (int i = 0; i < digits.length; i++) {
                System.out.print(digits[i]);
                if (i < digits.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            int[] result = obj.plusOne(digits);

            System.out.print("Output: ");
            System.out.print("[");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");

            System.out.println("-------------------------");
        }
    }
}
