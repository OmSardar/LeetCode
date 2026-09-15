// ============================ JULY-AUGUST PRACTICE ============================

//  Definition for a binary tree node.

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// RANK 1: Morris Preorder Traversal — O(n), O(1) — BEST / MOST SPACE EFFICIENT
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        
        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    result.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}

// RANK 2: Iterative Using Stack — O(n), O(h) — BEST PRACTICAL / RECOMMENDED
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);

//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             result.add(node.val);
//             if (node.right != null) {
//                 stack.push(node.right);
//             }
//             if (node.left != null) {
//                 stack.push(node.left);
//             }
//         }
//         return result;
//     }
// }


// RANK 3: Using Deque — O(n), O(h)
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }
//         Deque<TreeNode> stack = new ArrayDeque<>();
//         stack.push(root);

//         while (!stack.isEmpty()) {
//             TreeNode node = stack.pop();
//             result.add(node.val);
//             if (node.right != null) {
//                 stack.push(node.right);
//             }
//             if (node.left != null) {
//                 stack.push(node.left);
//             }
//         }
//         return result;
//     }
// }

// RANK 4: Recursive DFS — O(n), O(h) — RECURSION STACK
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         dfs(root, result);
//         return result;
//     }

//     private void dfs(TreeNode node, List<Integer> result) {
//         if (node == null) {
//             return;
//         }
//         result.add(node.val);
//         dfs(node.left, result);
//         dfs(node.right, result);
//     }
// }

// Driver code to test the Solution class
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // TEST CASE 1: Normal binary tree
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        //
        // Preorder: 1 2 4 5 3

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println(obj.preorderTraversal(root1));
        // Output: [1, 2, 4, 5, 3]


        // TEST CASE 2: Empty tree
        TreeNode root2 = null;

        System.out.println(obj.preorderTraversal(root2));
        // Output: []


        // TEST CASE 3: Only one node
        //     1
        TreeNode root3 = new TreeNode(1);

        System.out.println(obj.preorderTraversal(root3));
        // Output: [1]


        // TEST CASE 4: Left-skewed tree
        //       1
        //      /
        //     2
        //    /
        //   3
        //
        // Preorder: 1 2 3

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);

        System.out.println(obj.preorderTraversal(root4));
        // Output: [1, 2, 3]


        // TEST CASE 5: Right-skewed tree
        //     1
        //      \
        //       2
        //        \
        //         3
        //
        // Preorder: 1 2 3

        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);

        System.out.println(obj.preorderTraversal(root5));
        // Output: [1, 2, 3]


        // TEST CASE 6: More complex tree
        //          10
        //         /  \
        //        5    15
        //       / \     \
        //      3   7     20
        //
        // Preorder: 10 5 3 7 15 20

        TreeNode root6 = new TreeNode(10);
        root6.left = new TreeNode(5);
        root6.right = new TreeNode(15);
        root6.left.left = new TreeNode(3);
        root6.left.right = new TreeNode(7);
        root6.right.right = new TreeNode(20);

        System.out.println(obj.preorderTraversal(root6));
        // Output: [10, 5, 3, 7, 15, 20]
    }
}