// ============================ FINAL DESTINATION ============================

import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

// RANK 1: Recursive DFS — O(n) TIME, O(n) SPACE — BEST / MOST NATURAL

class Solution {
    public List<Integer> postorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // First visit all children from left to right
        for (Node child : root.children) {
            result.addAll(postorder(child));
        }

        // Visit the current node after all its children
        result.add(root.val);

        return result;
    }
}


// RANK 2: Iterative DFS using Stack — O(n) TIME, O(n) SPACE
// class Solution {

//     public List<Integer> postorder(Node root) {

//         List<Integer> result = new ArrayList<>();

//         if (root == null) {
//             return result;
//         }

//         Stack<Node> stack = new Stack<>();

//         stack.push(root);

//         while (!stack.isEmpty()) {

//             Node current = stack.pop();

//             result.add(current.val);

//             for (Node node : current.children) {
//                 stack.push(node);
//             }
//         }

//         Collections.reverse(result);

//         return result;
//     }
// }

// RANK 3: Recursive DFS with Separate Helper Method — O(n) TIME, O(n) SPACE

// class Solution {
//
//     public List<Integer> postorder(Node root) {
//
//         List<Integer> result = new ArrayList<>();
//
//         traverse(root, result);
//
//         return result;
//     }
//
//     private void traverse(Node node, List<Integer> result) {
//
//         if (node == null) {
//             return;
//         }
//
//         // Visit all children first
//         for (Node child : node.children) {
//             traverse(child, result);
//         }
//
//         // Visit current node last
//         result.add(node.val);
//     }
// }

// Driver code to test the Solution class
public class NaryTreePostorderTraversal {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // ============================================================
        // Test Case 1
        //
        //          1
        //       /  |  \
        //      3   2   4
        //     / \
        //    5   6
        //
        // Postorder:
        // 5 -> 6 -> 3 -> 2 -> 4 -> 1
        //
        // Answer: [5, 6, 3, 2, 4, 1]
        // ============================================================

        Node node5 = new Node(5, new ArrayList<>());
        Node node6 = new Node(6, new ArrayList<>());

        Node node3 = new Node(
                3,
                Arrays.asList(node5, node6));

        Node node2 = new Node(2, new ArrayList<>());
        Node node4 = new Node(4, new ArrayList<>());

        Node root1 = new Node(
                1,
                Arrays.asList(node3, node2, node4));

        System.out.println(solution.postorder(root1));

        // ============================================================
        // Test Case 2
        //
        //       1
        //     / | \
        //    2  3  4
        //
        // Postorder:
        // 2 -> 3 -> 4 -> 1
        //
        // Answer: [2, 3, 4, 1]
        // ============================================================

        Node node2_2 = new Node(2, new ArrayList<>());
        Node node3_2 = new Node(3, new ArrayList<>());
        Node node4_2 = new Node(4, new ArrayList<>());

        Node root2 = new Node(
                1,
                Arrays.asList(node2_2, node3_2, node4_2));

        System.out.println(solution.postorder(root2));

        // ============================================================
        // Test Case 3
        //
        // Single node
        //
        //       1
        //
        // Answer: [1]
        // ============================================================

        Node root3 = new Node(1, new ArrayList<>());

        System.out.println(solution.postorder(root3));

        // ============================================================
        // Test Case 4
        //
        // Empty tree
        //
        // Answer: []
        // ============================================================

        Node root4 = null;

        System.out.println(solution.postorder(root4));

        // ============================================================
        // Test Case 5
        //
        //        1
        //       /
        //      2
        //     /
        //    3
        //
        // Postorder:
        // 3 -> 2 -> 1
        //
        // Answer: [3, 2, 1]
        // ============================================================

        Node node3_5 = new Node(3, new ArrayList<>());

        Node node2_5 = new Node(
                2,
                Arrays.asList(node3_5));

        Node root5 = new Node(
                1,
                Arrays.asList(node2_5));

        System.out.println(solution.postorder(root5));
    }
}