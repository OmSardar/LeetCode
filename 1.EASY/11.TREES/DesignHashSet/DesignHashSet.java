// ============================ JULY-AUGUST PRACTICE ============================

// import java.util.BitSet;
// import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// RANK 1: BitSet — O(1) time, O(n) bits space — BEST MEMORY EFFICIENCY / FAST / CACHE-FRIENDLY
// class MyHashSet {
//     private BitSet bitSet; 
//     public MyHashSet() {
//         bitSet = new BitSet(1000001);
//     }

//     public void add(int key) {
//         bitSet.set(key);
//     }

//     public void remove(int key) {
//         bitSet.clear(key);
//     }

//     public boolean contains(int key) {
//         return bitSet.get(key);
//     }
// }

// RANK 2: Boolean Array (Direct Addressing) — O(1) time, O(n) space — VERY FAST / DIRECT ACCESS / SIMPLE
class MyHashSet {
    private boolean[] arr;

    public MyHashSet() {
        arr = new boolean[1000001];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}

// RANK 3: HashSet — O(1) average time, O(n) space — GENERAL PURPOSE / FLEXIBLE / HASHING OVERHEAD
// class MyHashSet {
//     HashSet<Integer> set;

//     public MyHashSet() {
//         set = new HashSet<>();
//     }

//     public void add(int key) {
//         set.add(key);
//     }

//     public void remove(int key) {
//         set.remove(key);
//     }

//     public boolean contains(int key) {
//         return set.contains(key);
//     }
// }

// RANK 4: Linked List with Hashing (Chaining) — O(1) average time, O(n) space — HASHING + LINKED-LIST OVERHEAD / CACHE-UNFRIENDLY

// class MyHashSet {
//     private List<Integer>[] buckets;
//     private int size = 1000;

//     @SuppressWarnings("unchecked")
//     public MyHashSet() {
//         buckets = new LinkedList[size];
//         for (int i = 0; i < size; i++) {
//             buckets[i] = new LinkedList<>();
//         }
//     }

//     private int hash(int key) {
//         return key % size;
//     }

//     public void add(int key) {
//         int index = hash(key);
//         if (!buckets[index].contains(key)) {
//             buckets[index].add(key);
//         }
//     }

//     public void remove(int key) {
//         int index = hash(key);
//         buckets[index].remove((Integer) key);
//     }

//     public boolean contains(int key) {
//         int index = hash(key);
//         return buckets[index].contains(key);
//     }
// }

// Driver code to test the Solution class
public class DesignHashSet {
    public static void main(String[] args) {

        // Test Case 1
        MyHashSet set1 = new MyHashSet();
        set1.add(1);
        set1.add(2);
        System.out.println(set1.contains(1)); // true
        System.out.println(set1.contains(3)); // false
        set1.remove(1);
        System.out.println(set1.contains(1)); // false

        // Test Case 2
        MyHashSet set2 = new MyHashSet();
        set2.add(10);
        set2.add(20);
        set2.add(10); // duplicate
        System.out.println(set2.contains(10)); // true
        set2.remove(20);
        System.out.println(set2.contains(20)); // false

        // Test Case 3
        MyHashSet set3 = new MyHashSet();
        set3.add(0);
        set3.add(1000000);
        System.out.println(set3.contains(0)); // true
        System.out.println(set3.contains(1000000)); // true
    }
}
