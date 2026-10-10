// ============================ JULY-AUGUST PRACTICE ============================

//  Definition for a binary tree node.

import java.util.LinkedList;
import java.util.Queue;
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

// RANK 1: Recursive DFS (BEST / MOST COMMON) — O(n), O(h)
class Solution {
    public int maxDepth(TreeNode root) {
      if (root ==null) {
        return 0;
      }
      return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// RANK 2: Iterative DFS Using Stack — O(n), O(h)
// class Solution {
//     public int maxDepth(TreeNode root) {
//       if (root == null) {
//         return 0;
//       }
//       Stack<TreeNode> nodeStack = new Stack<>();
//       Stack<Integer> depthStack = new Stack<>();
//       nodeStack.push(root);
//       depthStack.push(1);
      
//       int maxDepth = 0;

//       while (!nodeStack.isEmpty()) {
//         TreeNode node = nodeStack.pop();
//         int depth = depthStack.pop();
//         maxDepth = Math.max(maxDepth, depth);

//         if (node.left != null) {
//             nodeStack.push(node.left);
//             depthStack.push(depth + 1);
//         }

//         if (node.right != null) {
//             nodeStack.push(node.right);
//             depthStack.push(depth + 1);
//         }
//       }
//       return maxDepth;
//     }
// }

// RANK 3: BFS (Level-Order Traversal Using Queue) — O(n), O(w)
// class Solution {
//     public int maxDepth(TreeNode root) {
//          if (root == null) {
//         return 0;
//       }
//       Queue<TreeNode> nodeQueue = new LinkedList<>();
      
//       nodeQueue.offer(root);
//       int depth = 0;

//       while (!nodeQueue.isEmpty()) {
//         int size = nodeQueue.size();
//         depth++;
//         for(int i=0; i<size; i++){
//             TreeNode node = nodeQueue.poll();
//             if (node.left != null) {
//                 nodeQueue.offer(node.left);
//             }
//             if (node.right != null) {
//                 nodeQueue.offer(node.right);
//             }
//         }
//       }
//       return depth;
//     }
// }

// RANK 4: Top-Down DFS (Passing Depth Downwards) — O(n), O(h)
// class Solution {
//     int answer = 0;

//     public int maxDepth(TreeNode root) {
//         helper(root, 1);
//         return answer;
//     }

//     private void helper(TreeNode node, int depth) {
//         if (node == null) return;

//         // If it's a leaf, update answer
//         if (node.left == null && node.right == null) {
//             answer = Math.max(answer, depth);
//         }

//         helper(node.left, depth + 1);
//         helper(node.right, depth + 1);
//     }
// }

// Driver code to test the Solution class
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
               / \
              4   5

            Expected Answer: 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();

        int depth = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + depth);
    }
}