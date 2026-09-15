// ============================ JULY-AUGUST PRACTICE ============================

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

// RANK 1:  In-place Iterative O(n + m), O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head;

        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        return head;
    }
}

// RANK 2: Iterative (Using Dummy Node) O(n + m), O(1)
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//         if (list1 == null)
//             return list2;
//         if (list2 == null)
//             return list1;

//         ListNode dummy = new ListNode(0);
//         ListNode tail = dummy;

//         while (list1 != null && list2 != null) {
//             if (list1.val < list2.val) {
//                 tail.next = list1;
//                 list1 = list1.next;
//             } else {
//                 tail.next = list2;
//                 list2 = list2.next;
//             }
//             tail = tail.next;
//         }
//         if (list1 != null) {
//             tail.next = list1;
//         } else {
//             tail.next = list2;
//         }
//         return dummy.next;
//     }
// }

// RANK 3: Recursive O(n + m), O(n + m)
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

//         if (list1 == null)
//             return list2;
//         if (list2 == null)
//             return list1;

//         if (list1.val < list2.val) {
//                 list1.next = mergeTwoLists(list1.next, list2);
//                 return list1;
//             } else {
//                 list2.next = mergeTwoLists(list1, list2.next);
//                 return list2;
//             }
//     }
// }

//Driver code to test the Solution class
public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // List 1: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // List 2: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode merged = solution.mergeTwoLists(list1, list2);

        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
