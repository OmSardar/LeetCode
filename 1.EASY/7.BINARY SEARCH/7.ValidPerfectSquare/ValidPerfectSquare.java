// ============================ FINAL DESTINATION ============================

// RANK 1: Binary Search — O(log n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT

class Solution {
    public boolean isPerfectSquare(int num) {

        if (num < 2) {
            return true;
        }

        long left = 1;
        long right = num / 2;

        while (left <= right) {

            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == num) {
                return true;
            }

            if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}


// RANK 2: Newton's Method — O(log n) TIME, O(1) EXTRA SPACE — MATHEMATICAL / FAST
/*
class Solution {
    public boolean isPerfectSquare(int num) {

        if (num < 2) {
            return true;
        }

        long x = num;

        while (x * x > num) {
            x = (x + num / x) / 2;
        }

        return x * x == num;
    }
}
*/


// RANK 3: Linear Search — O(√n) TIME, O(1) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND
/*
class Solution {
    public boolean isPerfectSquare(int num) {

        for (long i = 1; i * i <= num; i++) {

            if (i * i == num) {
                return true;
            }
        }

        return false;
    }
}
*/


// Driver code to test the Solution class
public class ValidPerfectSquare {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[] tests = {
            16,
            14,
            1,
            4,
            9,
            25,
            36,
            49,
            100,
            121,
            2,
            3,
            15,
            10000,
            2147395600
        };

        for (int num : tests) {

            System.out.println(
                "Test " + num + ": " +
                solution.isPerfectSquare(num)
            );
        }

        /*
        Expected answers:

        Test 16: true
        Test 14: false
        Test 1: true
        Test 4: true
        Test 9: true
        Test 25: true
        Test 36: true
        Test 49: true
        Test 100: true
        Test 121: true
        Test 2: false
        Test 3: false
        Test 15: false
        Test 10000: true
        Test 2147395600: true
        */
    }
}