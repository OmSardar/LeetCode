// ============================ FINAL DESTINATION ============================

// Simulated VersionControl API for local testing
class VersionControl {

    private int firstBadVersion;

    public VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}


// LeetCode-style Solution
class Solution extends VersionControl {

    public Solution(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}


// Driver code
public class FirstBadVersion {

    public static void main(String[] args) {

        // Test Case 1
        int n = 7;
        int firstBad = 4;

        Solution solution = new Solution(firstBad);

        int answer = solution.firstBadVersion(n);

        System.out.println("Total versions: " + n);
        System.out.println("First bad version: " + firstBad);
        System.out.println("Answer: " + answer);

        System.out.println();


        // Test Case 2
        n = 10;
        firstBad = 6;

        solution = new Solution(firstBad);

        answer = solution.firstBadVersion(n);

        System.out.println("Total versions: " + n);
        System.out.println("First bad version: " + firstBad);
        System.out.println("Answer: " + answer);

        System.out.println();


        // Test Case 3
        n = 1;
        firstBad = 1;

        solution = new Solution(firstBad);

        answer = solution.firstBadVersion(n);

        System.out.println("Total versions: " + n);
        System.out.println("First bad version: " + firstBad);
        System.out.println("Answer: " + answer);
    }
}