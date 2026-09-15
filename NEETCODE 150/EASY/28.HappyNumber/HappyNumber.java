// ============================ JULY-AUGUST PRACTICE ============================
import java.util.*;

// RANK 1: Floyd’s Cycle Detection (Fast & Slow Pointer) — O(log n), O(1) — BEST ALGORITHMIC / INTERVIEW METHOD
class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);

        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}

// RANK 2: Using HashSet — O(log n), O(log n) — SIMPLEST / MOST INTUITIVE
// class Solution {
//     public boolean isHappy(int n) {
//         HashSet<Integer> seen = new HashSet<>();

//         while (n != 1 && !seen.contains(n)) {
//             seen.add(n);
//             n = getNext(n);
//         }
//         return n == 1;
//     }

//     private int getNext(int n) {
//         int sum = 0;
//         while (n > 0) {
//             int digit = n % 10;
//             sum += digit * digit;
//             n /= 10;
//         }
//         return sum;
//     }
// }


// RANK 3: Mathematical Observation (Hardcoded Cycle Check) — O(log n), O(1) — MOST OPTIMIZED, BUT LESS GENERAL
// class Solution {
//     public boolean isHappy(int n) {
//         while (n != 1 && n != 4) {
//             int sum = 0;
//             while (n > 0) {
//                 int remainder = n % 10;
//                 n = n / 10;
//                 int a = remainder * remainder;
//                 sum += a;
//             }

//             n = sum;
//         }
//         return n == 1;
//     }
// }

// RANK 4: Recursion + HashSet — O(log n), O(log n) — SIMPLE, BUT EXTRA STACK SPACE / LESS PREFERRED
// class Solution {
//     Set<Integer> seen = new HashSet<>();

//     public boolean isHappy(int n) {
//         if (n == 1) return true;
//         if (seen.contains(n)) return false;

//         seen.add(n);
//         return isHappy(getNext(n));
//     }

//     private int getNext(int n) {
//         int sum = 0;
//         while (n > 0) {
//             int d = n % 10;
//             sum += d * d;
//             n /= 10;
//         }
//         return sum;
//     }
// }

// Driver code to test the Solution class
public class HappyNumber {
    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] testCases = {1, 2, 7, 19, 20, 23, 10, 13};

        for (int n : testCases) {
            boolean result = obj.isHappy(n);

            System.out.println("Input: " + n);
            System.out.println("Is Happy Number: " + result);
            System.out.println("------------------------");
        }

        /*
        Expected Answers:

        1  -> true
        2  -> false
        7  -> true
        19 -> true
        20 -> false
        23 -> true
        10 -> true
        13 -> true
        */
    }
}