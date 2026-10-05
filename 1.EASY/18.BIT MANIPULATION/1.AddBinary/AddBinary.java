// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Manual Binary Addition (BEST) — O(n), O(n)
class Solution {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            int sum = carry;

            if (i >= 0) {
                sum = sum + a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum = sum + b.charAt(j) - '0';
                j--;
            }

            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}

// RANK 2: Recursion — O(n), O(n)
// class Solution {
//     public String addBinary(String a, String b) {
//         return add(a, b, a.length() - 1, b.length() - 1, 0);
//     }

//     private String add(String a, String b, int i, int j, int carry) {
//         if (i < 0 && j < 0 && carry == 0)
//             return "";

//         int sum = carry;
//         if (i >= 0)
//             sum += a.charAt(i) - '0';
//         if (j >= 0)
//             sum += b.charAt(j) - '0';

//         return add(a, b, i - 1, j - 1, sum / 2) + (sum % 2);
//     }
// }

// RANK 3: Bitwise Operations (XOR + AND) — O(n²), O(n)
// import java.math.BigInteger;

// class Solution {
//     public String addBinary(String a, String b) {
//         BigInteger x = new BigInteger(a, 2);
//         BigInteger y = new BigInteger(b, 2);

//         while (!y.equals(BigInteger.ZERO)) {
//             BigInteger carry = x.and(y);
//             x = x.xor(y);
//             y = carry.shiftLeft(1);
//         }

//         return x.toString(2);
//     }
// }

// RANK 4: Using BigInteger — O(n), O(n)
// import java.math.BigInteger;

// class Solution {
//     public String addBinary(String a, String b) {
//         BigInteger x = new BigInteger(a, 2);
//         BigInteger y = new BigInteger(b, 2);
//         return x.add(y).toString(2);
//     }
// }

// RANK 5: Convert to Integer (Limited Range) — O(n), O(1)
// class Solution {
//     public String addBinary(String a, String b) {
//         int x = Integer.parseInt(a, 2);
//         int y = Integer.parseInt(b, 2);
//         return Integer.toBinaryString(x + y);
//     }
// }

//Driver code to test the Solution class
public class AddBinary {
    public static void main(String[] args) {
        Solution obj = new Solution();

        System.out.println(obj.addBinary("11", "1")); // Expected: 100
        System.out.println(obj.addBinary("1010", "1011")); // Expected: 10101
        System.out.println(obj.addBinary("0", "0")); // Expected: 0
        System.out.println(obj.addBinary("1111", "1")); // Expected: 10000
        System.out.println(obj.addBinary("100", "110010")); // Expected: 110110
    }
}
