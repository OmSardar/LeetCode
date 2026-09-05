// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Mathematical GCD + String Check — O(m + n), O(m + n) SPACE — BEST / OPTIMAL / MOST EFFICIENT
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";

        int gcdLen = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLen);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}


// RANK 2: Brute Force — O((m + n) × min(m, n)), O(m + n) SPACE — SIMPLE / EASY TO UNDERSTAND
// class Solution {
//     public String gcdOfStrings(String str1, String str2) {
//         int minLen = Math.min(str1.length(), str2.length());

//         for (int i = minLen; i >= 1; i--) {
//             if (str1.length() % i == 0 && str2.length() % i == 0) {
//                 String base = str1.substring(0, i);
//                 if (isValid(str1, base) && isValid(str2, base)) {
//                     return base;
//                 }
//             }
//         }
//         return "";
//     }

//     private boolean isValid(String s, String base) {
//         int times = s.length() / base.length();
//         return base.repeat(times).equals(s);
//     }
// }

// RANK 3: Recursive Reduction — O(m + n) to O(m × n), O(m + n) SPACE — INTUITIVE / RECURSIVE ALTERNATIVE
// class Solution {
//     public String gcdOfStrings(String str1, String str2) {
//         if (str1.equals(str2)) return str1;
//         if (str1.length() < str2.length()) 
//             return gcdOfStrings(str2, str1);

//         if (str1.startsWith(str2)) {
//             return gcdOfStrings(str1.substring(str2.length()), str2);
//         }
//         return "";
//     }
// }


// RANK 4: Iterative Subtraction — O(m + n) to O(m × n), O(m + n) SPACE — SIMPLE BUT LESS EFFICIENT
// class Solution {
//     public String gcdOfStrings(String str1, String str2) {
//         while (!str1.equals(str2)) {
//             if (str1.length() > str2.length()) {
//                 if (!str1.startsWith(str2)) return "";
//                 str1 = str1.substring(str2.length());
//             } else {
//                 if (!str2.startsWith(str1)) return "";
//                 str2 = str2.substring(str1.length());
//             }
//         }
//         return str1;
//     }
// }

// Driver code to test the Solution class
public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1: Common GCD = "ABC"
        String str1 = "ABCABC";
        String str2 = "ABC";

        System.out.println(solution.gcdOfStrings(str1, str2)); // Answer: "ABC"

        // Test Case 2: Common GCD = "AB"
        String str3 = "ABABAB";
        String str4 = "ABAB";

        System.out.println(solution.gcdOfStrings(str3, str4)); // Answer: "AB"

        // Test Case 3: No Common GCD
        String str5 = "LEET";
        String str6 = "CODE";

        System.out.println(solution.gcdOfStrings(str5, str6)); // Answer: ""

        // Test Case 4: Same Strings
        String str7 = "AAAA";
        String str8 = "AAAA";

        System.out.println(solution.gcdOfStrings(str7, str8)); // Answer: "AAAA"

        // Test Case 5: Single Character GCD
        String str9 = "AAAAAA";
        String str10 = "AAA";

        System.out.println(solution.gcdOfStrings(str9, str10)); // Answer: "AAA"

        // Test Case 6: GCD = "A"
        String str11 = "AAAA";
        String str12 = "AA";

        System.out.println(solution.gcdOfStrings(str11, str12)); // Answer: "AA"

        // Test Case 7: No Common Divisor
        String str13 = "ABC";
        String str14 = "AB";

        System.out.println(solution.gcdOfStrings(str13, str14)); // Answer: ""

        // Test Case 8: GCD = "XYZ"
        String str15 = "XYZXYZXYZ";
        String str16 = "XYZXYZ";

        System.out.println(solution.gcdOfStrings(str15, str16)); // Answer: "XYZ"
    }
}