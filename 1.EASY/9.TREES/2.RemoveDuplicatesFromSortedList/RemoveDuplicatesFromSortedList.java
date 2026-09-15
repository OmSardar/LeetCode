// ============================ FINAL DESTINATION ============================

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


// RANK 1: One-Pass Two-Pointer — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;

        while (current != null && current.next != null) {

            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}


// RANK 2: Recursive — O(n) TIME, O(n) STACK SPACE — SIMPLE / ELEGANT
/*
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        head.next = deleteDuplicates(head.next);

        if (head.val == head.next.val) {
            return head.next;
        }

        return head;
    }
}
*/


// RANK 3: HashSet — O(n) TIME, O(n) SPACE — GENERAL / WORKS WITHOUT SORTING
/*
import java.util.HashSet;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        HashSet<Integer> set = new HashSet<>();

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {

            if (set.contains(current.val)) {
                previous.next = current.next;
            } else {
                set.add(current.val);
                previous = current;
            }

            current = current.next;
        }

        return head;
    }
}
*/


// Driver code to test the Solution class
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test 1: 1 → 1 → 2
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);

        System.out.print("Test 1: ");
        printList(solution.deleteDuplicates(head1));
        // Answer: 1 → 2


        // Test 2: 1 → 1 → 2 → 3 → 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);
        head2.next.next.next.next = new ListNode(3);

        System.out.print("Test 2: ");
        printList(solution.deleteDuplicates(head2));
        // Answer: 1 → 2 → 3


        // Test 3: 1 → 1 → 1 → 1
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(1);
        head3.next.next = new ListNode(1);
        head3.next.next.next = new ListNode(1);

        System.out.print("Test 3: ");
        printList(solution.deleteDuplicates(head3));
        // Answer: 1


        // Test 4: 1 → 2 → 3 → 4
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        head4.next.next = new ListNode(3);
        head4.next.next.next = new ListNode(4);

        System.out.print("Test 4: ");
        printList(solution.deleteDuplicates(head4));
        // Answer: 1 → 2 → 3 → 4


        // Test 5: 1 → 1
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(1);

        System.out.print("Test 5: ");
        printList(solution.deleteDuplicates(head5));
        // Answer: 1


        // Test 6: Empty list
        ListNode head6 = null;

        System.out.print("Test 6: ");
        printList(solution.deleteDuplicates(head6));
        // Answer: Empty


        // Test 7: Single node
        ListNode head7 = new ListNode(5);

        System.out.print("Test 7: ");
        printList(solution.deleteDuplicates(head7));
        // Answer: 5


        // Test 8: 1 → 2 → 2 → 2 → 3 → 3 → 4
        ListNode head8 = new ListNode(1);
        head8.next = new ListNode(2);
        head8.next.next = new ListNode(2);
        head8.next.next.next = new ListNode(2);
        head8.next.next.next.next = new ListNode(3);
        head8.next.next.next.next.next = new ListNode(3);
        head8.next.next.next.next.next.next = new ListNode(4);

        System.out.print("Test 8: ");
        printList(solution.deleteDuplicates(head8));
        // Answer: 1 → 2 → 3 → 4
    }


    // Helper method to print the linked list
    public static void printList(ListNode head) {

        if (head == null) {
            System.out.println("Empty");
            return;
        }

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" → ");
            }

            current = current.next;
        }

        System.out.println();
    }
}