// ============================ FINAL DESTINATION ============================

// RANK 1: Bit Manipulation + Enumeration — O(1) TIME, O(1) EXTRA SPACE* — BEST / OPTIMAL / MOST DIRECT
// *Output space is not counted.
//
// There are only 12 possible hours and 60 possible minutes.
// For every possible time, count the number of set bits.
// If hour bits + minute bits == turnedOn, the time is valid.

import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                int count = Integer.bitCount(hour) + Integer.bitCount(minute);

                if (count == turnedOn) {
                    result.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
                }
            }
        }

        return result;
    }
}

// Driver code to test the Solution class
public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(
            solution.readBinaryWatch(0)
        ); // Answer: [0:00]

        System.out.println(
            solution.readBinaryWatch(1)
        ); // Answer: [0:01, 0:02, 0:04, 0:08, 0:16, 0:32, 1:00, 2:00, 4:00, 8:00]

        System.out.println(
            solution.readBinaryWatch(2)
        ); // Answer: [0:03, 0:05, 0:06, 0:09, 0:10, 0:12, 0:17, 0:18, 0:20, 0:24, 0:33, 0:34, 0:36, 0:40, 0:48, 1:01, 1:02, 1:04, 1:08, 1:16, 1:32, 2:01, 2:02, 2:04, 2:08, 2:16, 2:32, 3:00, 4:01, 4:02, 4:04, 4:08, 4:16, 4:32, 5:00, 6:00, 8:01, 8:02, 8:04, 8:08, 8:16, 8:32, 9:00, 10:00]

        System.out.println(
            solution.readBinaryWatch(3)
        ); // Answer: multiple valid times

        System.out.println(
            solution.readBinaryWatch(8)
        ); // Answer: []

        System.out.println(
            solution.readBinaryWatch(9)
        ); // Answer: []
    }
}