
// ============================ JULY-AUGUST PRACTICE ============================

//  Definition for a binary tree node.

import java.util.ArrayList;
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

// RANK 1: Morris Traversal (BEST / OPTIMAL) — O(n), O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;

    }
}


// RANK 2: Iterative Using Stack — O(n), O(h)
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         Stack<TreeNode> stack = new Stack<>();

//         TreeNode curr = root;

//         while (curr != null || !stack.isEmpty()) {
//             while (curr != null) {
//                 stack.push(curr);
//                 curr = curr.left;
//             }
//             curr = stack.pop();
//             result.add(curr.val);
//             curr = curr.right;
//         }
//         return result;
//     }
// }

// RANK 3: Recursive DFS — O(n), O(h)
//  class Solution {
//      List<Integer> result = new ArrayList<>();

//      public List<Integer> inorderTraversal(TreeNode root) {
//         dfs(root);
//          return result;
//      }

//      private void dfs(TreeNode node){
//         if (node == null) {
//              return;
//          }
//          dfs(node.left);
//          result.add(node.val);
//          dfs(node.right);

//      }
//  }

// RANK 4: Color Marking / State Technique (General Traversal Pattern) — O(n), O(n)
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         Stack<Object[]> stack = new Stack<>();

//         stack.push(new Object[]{root, 0});

//         while (!stack.isEmpty()) {
//             Object[] top = stack.pop();
//             TreeNode node = (TreeNode) top[0];
//             int state = (int) top[1];

//             if (node == null) continue;

//             if (state == 0) {
//                 stack.push(new Object[]{node.right, 0});
//                 stack.push(new Object[]{node, 1});
//                 stack.push(new Object[]{node.left, 0});
//             } else {
//                 result.add(node.val);
//             }
//         }
//         return result;
//     }
// }

// Driver code to test the Solution class
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        // Construct the tree:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     8
        //       / \   /
        //      6   7 9

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        Solution obj = new Solution();

        List<Integer> result = obj.inorderTraversal(root);

        System.out.println(result);
    }
}