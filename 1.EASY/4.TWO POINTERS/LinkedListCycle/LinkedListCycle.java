// ============================ JULY-AUGUST PRACTICE ============================
import java.util.HashMap;
import java.util.HashSet;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// RANK 1: Floyd’s Cycle Detection Algorithm (Tortoise & Hare) — O(n), O(1) — BEST / MOST EFFICIENT
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

// RANK 2: Modify Node Values / Mark Visited — O(n), O(1) — NOT RECOMMENDED
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode current = head;

//         while (current != null) {
//             if (current.val == Integer.MIN_VALUE) {
//                 return true;
//             }
//             current.val = Integer.MIN_VALUE;
//             current = current.next;
//         }
//         return false;
//     }
// }

// RANK 3: HashSet Method — O(n), O(n) — WORST / LEAST EFFICIENT
// class Solution {
//     public boolean hasCycle(ListNode head) {
//         HashSet<ListNode> map = new HashSet<>();

//         ListNode current = head;
//         while (current != null) {
//             if (map.contains(current)) {
//                 return true;
//             }
//             map.add(current);
//             current = current.next;
//         }
//         return false;
//     }
// }

// Driver code to test the Solution class
public class LinkedListCycle {
    public static void main(String[] args) {

        Solution obj = new Solution();


        // TEST CASE 1: Cycle exists
        // 3 → 2 → 0 → -4
        //     ↑         ↓
        //     └─────────┘
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);

        // Create cycle: -4 → 2
        head1.next.next.next.next = head1.next;

        System.out.println(obj.hasCycle(head1)); // Output: true


        // TEST CASE 2: No cycle
        // 1 → 2 → 3 → null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println(obj.hasCycle(head2)); // Output: false


        // TEST CASE 3: Empty linked list
        // null
        ListNode head3 = null;

        System.out.println(obj.hasCycle(head3)); // Output: false


        // TEST CASE 4: Only one node, no cycle
        // 1 → null
        ListNode head4 = new ListNode(1);

        System.out.println(obj.hasCycle(head4)); // Output: false


        // TEST CASE 5: One node points to itself
        // 1 ─┐
        // ↑  │
        // └──┘
        ListNode head5 = new ListNode(1);
        head5.next = head5;

        System.out.println(obj.hasCycle(head5)); // Output: true


        // TEST CASE 6: Cycle starts at head
        // 1 → 2 → 3
        // ↑       ↓
        // └───────┘
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        head6.next.next = new ListNode(3);

        // Create cycle: 3 → 1
        head6.next.next.next = head6;

        System.out.println(obj.hasCycle(head6)); // Output: true
    }
}