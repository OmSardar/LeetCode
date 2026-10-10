// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Stack (Two Stacks) — O(1) Amortized Push/Pop/Peek, O(n) Space — BEST PRACTICAL / MOST EFFICIENT / MOST USED

import java.util.Stack;

class MyQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }

    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty, Underflow!");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty, Underflow!");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// Driver code to test the Solution class
public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

        MyQueue obj = new MyQueue();

        // Push elements
        obj.push(10);
        obj.push(20);
        obj.push(30);

        // Test peek()
        System.out.println("Front: " + obj.peek());           // Front: 10

        // Test pop()
        System.out.println("Popped: " + obj.pop());          // Popped: 10
        System.out.println("Popped: " + obj.pop());          // Popped: 20

        // Test peek() again
        System.out.println("Front: " + obj.peek());           // Front: 30

        // Test empty()
        System.out.println("Is Empty: " + obj.empty());       // Is Empty: false

        // Pop remaining element
        System.out.println("Popped: " + obj.pop());          // Popped: 30

        // Test empty() again
        System.out.println("Is Empty: " + obj.empty());       // Is Empty: true
    }
}
