// ============================ JULY-AUGUST PRACTICE ============================

// Definition for a binary tree node.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

// RANK 1: Modified Preorder + Reverse — O(n), O(h) — BEST PRACTICAL / CLEVER
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return result;
    }
}

// RANK 2: Iterative Using ONE STACK — O(n), O(h) — BEST TRADITIONAL ITERATIVE
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode curr = root;
//         TreeNode lastVisited = null;
        
//         while (curr != null || !stack.isEmpty()) {
//             if (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             } else {
//                 TreeNode peek = stack.peek();
//                 if (peek.right != null && lastVisited != peek.right) {
//                     curr = peek.right;
//                 } else {
//                     result.add(peek.val);
//                     lastVisited = stack.pop();
//                 }
//             }
//         }
//         return result;
//     }
// }

// RANK 3: Recursive DFS — O(n), O(h) — SIMPLEST / MOST INTUITIVE
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         dfs(root, result);
//         return result;
//     }

//     private void dfs(TreeNode node, List<Integer> result) {
//         if (node == null) {
//             return;
//         }
//         dfs(node.left, result);
//         dfs(node.right, result);
//         result.add(node.val);
//     }
// }

// RANK 4: Iterative Using TWO STACKS — O(n), O(n) — CORRECT, BUT MOST SPACE
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) {
//             return result;
//         }
//         Stack<TreeNode> stack1 = new Stack<>();
//         Stack<TreeNode> stack2 = new Stack<>();

//         stack1.push(root);
//         while (!stack1.isEmpty()) {
//             TreeNode node = stack1.pop();
//             stack2.push(node);
//             if (node.left != null) {
//                 stack1.push(node.left);
//             }
//             if (node.right != null) {
//                 stack1.push(node.right);
//             }
//         }
//         while (!stack2.isEmpty()) {
//             result.add(stack2.pop().val);
//         }
//         return result;
//     }
// }

// Driver code to test the Solution class
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {

        Solution obj = new Solution();

        // TEST CASE 1: Normal binary tree
        //          1
        //         / \
        //        2   3
        //       / \
        //      4   5
        //
        // Postorder: 4 5 2 3 1

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        System.out.println(obj.postorderTraversal(root1));
        // Output: [4, 5, 2, 3, 1]

        // TEST CASE 2: Empty tree

        TreeNode root2 = null;

        System.out.println(obj.postorderTraversal(root2));
        // Output: []

        // TEST CASE 3: Only one node
        //     1

        TreeNode root3 = new TreeNode(1);

        System.out.println(obj.postorderTraversal(root3));
        // Output: [1]

        // TEST CASE 4: Left-skewed tree
        //       1
        //      /
        //     2
        //    /
        //   3
        //
        // Postorder: 3 2 1

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);

        System.out.println(obj.postorderTraversal(root4));
        // Output: [3, 2, 1]

        // TEST CASE 5: Right-skewed tree
        //     1
        //      \
        //       2
        //        \
        //         3
        //
        // Postorder: 3 2 1

        TreeNode root5 = new TreeNode(1);
        root5.right = new TreeNode(2);
        root5.right.right = new TreeNode(3);

        System.out.println(obj.postorderTraversal(root5));
        // Output: [3, 2, 1]

        // TEST CASE 6: More complex tree
        //          10
        //         /  \
        //        5    15
        //       / \     \
        //      3   7     20
        //
        // Postorder: 3 7 5 20 15 10

        TreeNode root6 = new TreeNode(10);
        root6.left = new TreeNode(5);
        root6.right = new TreeNode(15);
        root6.left.left = new TreeNode(3);
        root6.left.right = new TreeNode(7);
        root6.right.right = new TreeNode(20);

        System.out.println(obj.postorderTraversal(root6));
        // Output: [3, 7, 5, 20, 15, 10]
    }
}