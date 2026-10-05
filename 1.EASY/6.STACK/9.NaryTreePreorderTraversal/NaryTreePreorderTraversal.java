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
    public List<Integer> preorder(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Visit the current node first
        result.add(root.val);

        // Then visit all children from left to right
        for (Node child : root.children) {
            result.addAll(preorder(child));
        }

        return result;
    }
}


// RANK 2: Iterative DFS using Stack — O(n) TIME, O(n) SPACE

// class Solution {

//     public List<Integer> preorder(Node root) {

//         List<Integer> result = new ArrayList<>();

//         if (root == null) {
//             return result;
//         }

//         Stack<Node> stack = new Stack<>();

//         stack.push(root);

//         while (!stack.isEmpty()) {

//             Node current = stack.pop();

//             result.add(current.val);

//             for (int i = current.children.size() - 1; i >= 0; i--) {
//                 stack.push(current.children.get(i));
//             }
//         }

//         return result;
//     }
// }

// RANK 3: Recursive DFS with Separate Helper Method — O(n) TIME, O(n) SPACE

// class Solution {

//     public List<Integer> preorder(Node root) {

//         List<Integer> result = new ArrayList<>();

//         traverse(root, result);

//         return result;
//     }

//     private void traverse(Node node, List<Integer> result) {

//         if (node == null) {
//             return;
//         }

//         result.add(node.val);

//         for (Node child : node.children) {
//             traverse(child, result);
//         }
//     }
// }


// Driver code to test the Solution class
public class NaryTreePreorderTraversal {

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
        // Answer: [1, 3, 5, 6, 2, 4]
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

        System.out.println(solution.preorder(root1));

        // ============================================================
        // Test Case 2
        //
        //       1
        //     / | \
        //    2  3  4
        //
        // Answer: [1, 2, 3, 4]
        // ============================================================

        Node root2 = new Node(
                1,
                Arrays.asList(
                        new Node(2, new ArrayList<>()),
                        new Node(3, new ArrayList<>()),
                        new Node(4, new ArrayList<>())));

        System.out.println(solution.preorder(root2));

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

        System.out.println(solution.preorder(root3));

        // ============================================================
        // Test Case 4
        //
        // Empty tree
        //
        // Answer: []
        // ============================================================

        Node root4 = null;

        System.out.println(solution.preorder(root4));

        // ============================================================
        // Test Case 5
        //
        //        1
        //       /
        //      2
        //     /
        //    3
        //
        // Answer: [1, 2, 3]
        // ============================================================

        Node node3_5 = new Node(3, new ArrayList<>());

        Node node2_5 = new Node(
                2,
                Arrays.asList(node3_5));

        Node root5 = new Node(
                1,
                Arrays.asList(node2_5));

        System.out.println(solution.preorder(root5));
    }
}