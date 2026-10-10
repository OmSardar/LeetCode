// ============================ JULY-AUGUST PRACTICE ============================

// RANK 1: Queue (One Queue) — O(n) Push, O(1) Pop/Top, O(n) Space — BEST PRACTICAL / SIMPLEST / MOST EFFICIENT

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }
    
    public int pop() {
        if (empty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.poll();
    }
    
    public int top() {
        if (empty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// Driver code to test the MyStack class
public class ImplementStackUsingQueues {
    public static void main(String[] args) {

        MyStack obj = new MyStack();

        // Push elements
        obj.push(10);
        obj.push(20);
        obj.push(30);

        // Test top()
        System.out.println("Top: " + obj.top());              // Top: 30

        // Test pop()
        System.out.println("Popped: " + obj.pop());          // Popped: 30
        System.out.println("Popped: " + obj.pop());          // Popped: 20

        // Test top() again
        System.out.println("Top: " + obj.top());              // Top: 10

        // Test empty()
        System.out.println("Is Empty: " + obj.empty());       // Is Empty: false

        // Pop remaining element
        System.out.println("Popped: " + obj.pop());          // Popped: 10

        // Test empty() again
        System.out.println("Is Empty: " + obj.empty());       // Is Empty: true
    }
}