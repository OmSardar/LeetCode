// ============================ JULY-AUGUST PRACTICE ============================

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// RANK 1: Direct Address Table — O(1) time, O(n) space — BEST FOR THIS PROBLEM / SIMPLE / FASTEST
class MyHashMap {
    private int[] map;

    public MyHashMap() {
        map = new int[1000001];
        for (int i = 0; i < map.length; i++) {
            map[i] = -1;
        }
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}


// RANK 2: Hashing with Separate Chaining (LinkedList Buckets) — O(1) average time, O(n) space — BEST FOR LEARNING HASH TABLE INTERNALS / COLLISION HANDLING
// class MyHashMap {
//     private static final int SIZE = 1000;
//     private List<int[]>[] buckets;

//     @SuppressWarnings("unchecked")
//     public MyHashMap() {
//         buckets = new LinkedList[SIZE];
//     }

//     private int hash(int key) {
//         return key % SIZE;
//     }

//     public void put(int key, int value) {
//         int index = hash(key);
//         if (buckets[index] == null)
//             buckets[index] = new LinkedList<>();

//         for (int[] pair : buckets[index]) {
//             if (pair[0] == key) {
//                 pair[1] = value;
//                 return;
//             }
//         }
//         buckets[index].add(new int[]{key, value});
//     }

//     public int get(int key) {
//         int index = hash(key);
//         if (buckets[index] == null) return -1;

//         for (int[] pair : buckets[index]) {
//             if (pair[0] == key) return pair[1];
//         }
//         return -1;
//     }

//     public void remove(int key) {
//         int index = hash(key);
//         if (buckets[index] == null) return;

//         buckets[index].removeIf(pair -> pair[0] == key);
//     }
// }

// RANK 3: Hashing with Fixed Array Buckets — O(1) average time, O(n) space — CLEANER BUCKET IMPLEMENTATION / GOOD HASHING PRACTICE
// import java.util.*;

// class MyHashMap {
//     private static final int SIZE = 769;
//     private List<int[]>[] buckets;

//     public MyHashMap() {
//         buckets = new ArrayList[SIZE];
//         for (int i = 0; i < SIZE; i++) {
//             buckets[i] = new ArrayList<>();
//         }
//     }

//     private int hash(int key) {
//         return key % SIZE;
//     }

//     public void put(int key, int value) {
//         int h = hash(key);
//         for (int[] pair : buckets[h]) {
//             if (pair[0] == key) {
//                 pair[1] = value;
//                 return;
//             }
//         }
//         buckets[h].add(new int[]{key, value});
//     }

//     public int get(int key) {
//         int h = hash(key);
//         for (int[] pair : buckets[h]) {
//             if (pair[0] == key) return pair[1];
//         }
//         return -1;
//     }

//     public void remove(int key) {
//         int h = hash(key);
//         buckets[h].removeIf(pair -> pair[0] == key);
//     }
// }

// RANK 4: Brute Force (Array of Pairs) — O(n) time, O(n) space — SIMPLEST / BEST FOR UNDERSTANDING THE BASIC IDEA / SLOW
// class MyHashMap {

//     private List<int[]> list;

//     public MyHashMap() {
//         list = new ArrayList<>();        
//     }
    
//     public void put(int key, int value) {
//         for (int[] pair : list) {
//             if (pair[0] == key) {
//                 pair[1] = value;
//                 return;
//             }
//         }
//         list.add(new int[] { key, value });
//     }
    
//     public int get(int key) {
//         for (int[] pair : list) {
//             if (pair[0] == key) {
//                 return pair[1];
//             }
//         }
//         return -1;
//     }
    
//     public void remove(int key) {
//         Iterator<int[]> it = list.iterator();
//         while (it.hasNext()) {
//             if (it.next()[0] == key) {
//                 it.remove();
//                 return;
//             }
//         }
//     }
// }

// Driver code to test the Solution class
public class DesignHashMap {
    public static void main(String[] args) {

        // Test Case 1
        MyHashMap map1 = new MyHashMap();
        map1.put(1, 10);
        map1.put(2, 20);
        System.out.println(map1.get(1)); // 10
        System.out.println(map1.get(3)); // -1

        // Test Case 2
        MyHashMap map2 = new MyHashMap();
        map2.put(5, 50);
        map2.put(5, 100); // update
        System.out.println(map2.get(5)); // 100
        map2.remove(5);
        System.out.println(map2.get(5)); // -1

        // Test Case 3
        MyHashMap map3 = new MyHashMap();
        map3.put(0, 99);
        map3.put(1000000, 88);
        System.out.println(map3.get(0));       // 99
        System.out.println(map3.get(1000000)); // 88
    }
}
