// ============================ FINAL DESTINATION ============================

// RANK 1: Mathematical Counting — O(n) TIME, O(1) SPACE — BEST / OPTIMAL / MOST PRACTICAL

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;

        for (int i = 0; i < tickets.length; i++) {

            // People before or at k can buy at most
            // tickets[k] tickets.
            if (i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            }

            // People after k leave the queue as soon as
            // person k buys their last ticket.
            else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}


// RANK 2: Queue Simulation — O(n × tickets[k]) TIME, O(n) SPACE — Direct Simulation

// import java.util.*;
//
// class Solution {
//     public int timeRequiredToBuy(int[] tickets, int k) {
//
//         Queue<Integer> queue = new LinkedList<>();
//
//         for (int i = 0; i < tickets.length; i++) {
//             queue.offer(i);
//         }
//
//         int time = 0;
//
//         while (!queue.isEmpty()) {
//
//             int person = queue.poll();
//
//             // This person buys one ticket
//             tickets[person]--;
//             time++;
//
//             // Person still needs tickets
//             if (tickets[person] > 0) {
//
//                 queue.offer(person);
//
//             } else {
//
//                 // Person k just bought their final ticket
//                 if (person == k) {
//                     break;
//                 }
//             }
//         }
//
//         return time;
//     }
// }


// RANK 3: Simple Simulation with Array — O(n × tickets[k]) TIME, O(1) SPACE

// class Solution {
//     public int timeRequiredToBuy(int[] tickets, int k) {
//
//         int time = 0;
//
//         while (tickets[k] > 0) {
//
//             for (int i = 0; i < tickets.length; i++) {
//
//                 if (tickets[i] > 0) {
//
//                     tickets[i]--;
//                     time++;
//
//                     // Person k just bought their last ticket
//                     if (i == k && tickets[k] == 0) {
//                         return time;
//                     }
//                 }
//             }
//         }
//
//         return time;
//     }
// }


// Driver code to test the Solution class

public class TimeNeededToBuyTickets {

    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test Case 1
        int[] tickets1 = {2, 3, 2};

        System.out.println(
            solution.timeRequiredToBuy(tickets1, 2)
        );
        // Answer: 6


        // Test Case 2
        int[] tickets2 = {5, 1, 1, 1};

        System.out.println(
            solution.timeRequiredToBuy(tickets2, 0)
        );
        // Answer: 8


        // Test Case 3
        int[] tickets3 = {1, 1, 1};

        System.out.println(
            solution.timeRequiredToBuy(tickets3, 0)
        );
        // Answer: 1


        // Test Case 4
        int[] tickets4 = {3, 2, 2};

        System.out.println(
            solution.timeRequiredToBuy(tickets4, 1)
        );
        // Answer: 5


        // Test Case 5
        int[] tickets5 = {4, 5, 1, 2};

        System.out.println(
            solution.timeRequiredToBuy(tickets5, 1)
        );
        // Answer: 12
    }
}