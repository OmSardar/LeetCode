// ============================ FINAL DESTINATION ============================

// RANK 1: Queue — O(n) TIME, O(n) SPACE — BEST / OPTIMAL / MOST PRACTICAL

import java.util.*;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {

        // Add the current request
        queue.offer(t);

        // Remove requests older than t - 3000
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        // Remaining requests are inside [t - 3000, t]
        return queue.size();
    }
}

// RANK 2: ArrayList + Two Pointers — O(n) TIME, O(n) SPACE — Good alternative

// class RecentCounter {
//
//     ArrayList<Integer> requests;
//     int left;
//
//     public RecentCounter() {
//         requests = new ArrayList<>();
//         left = 0;
//     }
//
//     public int ping(int t) {
//
//         requests.add(t);
//
//         while (requests.get(left) < t - 3000) {
//             left++;
//         }
//
//         return requests.size() - left;
//     }
// }

// RANK 3: LinkedList directly — O(n) TIME, O(n) SPACE — Simple alternative

// import java.util.LinkedList;

// class RecentCounter {
    
//     LinkedList<Integer> requests;

//     public RecentCounter() {
//         requests = new LinkedList<>();
//     }
    
//     public int ping(int t) {
//         requests.addLast(t);

//         while (requests.getFirst() < t - 3000) {
//             requests.removeFirst();
//         }
//         return requests.size();
//     }
// }

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

// Driver code to test the RecentCounter class
public class NumberOfRecentCalls {

    public static void main(String[] args) {

        RecentCounter counter = new RecentCounter();

        System.out.println(counter.ping(1));
        // Answer: 1

        System.out.println(counter.ping(100));
        // Answer: 2

        System.out.println(counter.ping(3001));
        // Answer: 3

        System.out.println(counter.ping(3002));
        // Answer: 3


        // Explanation:
        //
        // ping(1)
        // Window = [-2999, 1]
        // Requests = [1]
        // Answer = 1
        //
        // ping(100)
        // Window = [-2900, 100]
        // Requests = [1, 100]
        // Answer = 2
        //
        // ping(3001)
        // Window = [1, 3001]
        // Requests = [1, 100, 3001]
        // Answer = 3
        //
        // ping(3002)
        // Window = [2, 3002]
        // 1 is removed because 1 < 2
        // Requests = [100, 3001, 3002]
        // Answer = 3
    }
}