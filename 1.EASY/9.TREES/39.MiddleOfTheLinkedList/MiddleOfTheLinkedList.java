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


// RANK 1: Slow & Fast Pointers — O(n) TIME, O(1) EXTRA SPACE — BEST / OPTIMAL / MOST EFFICIENT

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}


// RANK 2: Count Length + Traverse Again — O(n) TIME, O(1) EXTRA SPACE — SIMPLE / EASY TO UNDERSTAND
/*
class Solution {
    public ListNode middleNode(ListNode head) {

        int length = 0;
        ListNode current = head;

        // Find length
        while (current != null) {
            length++;
            current = current.next;
        }

        // Move to middle
        int middle = length / 2;

        current = head;

        for (int i = 0; i < middle; i++) {
            current = current.next;
        }

        return current;
    }
}
*/


// RANK 3: ArrayList — O(n) TIME, O(n) SPACE — SIMPLE / DIRECT
/*
import java.util.*;

class Solution {
    public ListNode middleNode(ListNode head) {

        ArrayList<ListNode> nodes = new ArrayList<>();

        ListNode current = head;

        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        return nodes.get(nodes.size() / 2);
    }
}
*/


// Driver code to test the Solution class
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {

        Solution solution = new Solution();


        // Test 1: 1 → 2 → 3 → 4 → 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println(
            "Test 1: " +
            solution.middleNode(head1).val +
            "    // Answer: 3"
        );


        // Test 2: 1 → 2 → 3 → 4 → 5 → 6
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        System.out.println(
            "Test 2: " +
            solution.middleNode(head2).val +
            "    // Answer: 4"
        );


        // Test 3: 1
        ListNode head3 = new ListNode(1);

        System.out.println(
            "Test 3: " +
            solution.middleNode(head3).val +
            "    // Answer: 1"
        );


        // Test 4: 1 → 2
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);

        System.out.println(
            "Test 4: " +
            solution.middleNode(head4).val +
            "    // Answer: 2"
        );


        // Test 5: 1 → 2 → 3
        ListNode head5 = new ListNode(1);
        head5.next = new ListNode(2);
        head5.next.next = new ListNode(3);

        System.out.println(
            "Test 5: " +
            solution.middleNode(head5).val +
            "    // Answer: 2"
        );


        // Test 6: 1 → 2 → 3 → 4
        ListNode head6 = new ListNode(1);
        head6.next = new ListNode(2);
        head6.next.next = new ListNode(3);
        head6.next.next.next = new ListNode(4);

        System.out.println(
            "Test 6: " +
            solution.middleNode(head6).val +
            "    // Answer: 3"
        );


        // Test 7: 10 → 20 → 30 → 40 → 50 → 60 → 70
        ListNode head7 = new ListNode(10);
        head7.next = new ListNode(20);
        head7.next.next = new ListNode(30);
        head7.next.next.next = new ListNode(40);
        head7.next.next.next.next = new ListNode(50);
        head7.next.next.next.next.next = new ListNode(60);
        head7.next.next.next.next.next.next = new ListNode(70);

        System.out.println(
            "Test 7: " +
            solution.middleNode(head7).val +
            "    // Answer: 40"
        );


        // Test 8: 5 → 10 → 15 → 20 → 25 → 30 → 35 → 40
        ListNode head8 = new ListNode(5);
        head8.next = new ListNode(10);
        head8.next.next = new ListNode(15);
        head8.next.next.next = new ListNode(20);
        head8.next.next.next.next = new ListNode(25);
        head8.next.next.next.next.next = new ListNode(30);
        head8.next.next.next.next.next.next = new ListNode(35);
        head8.next.next.next.next.next.next.next = new ListNode(40);

        System.out.println(
            "Test 8: " +
            solution.middleNode(head8).val +
            "    // Answer: 25"
        );
    }
}