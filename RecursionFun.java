/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1)
			return n;
		if (n == k)
			return 1;
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n == 0)
			return "";
		else if (n < 1000)
			return "" + n;
		else {
			int quotient = n / 1000;
			int remainder = n % 1000;
			String remainderString = "" + remainder;
			if (remainder < 10)
				return intWithCommas(quotient) + "," + "00" + remainderString;
			else if (remainder < 100)
				return intWithCommas(quotient) + "," + "0" + remainderString;
			else
				return intWithCommas(quotient) + "," + remainderString;
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of the array indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index >= len) {
			return;
		}
		int temp = x[index];
		x[index] = x[len - 1];
		x[len - 1] = temp;

		reverseArray(x, index + 1, len - 1);
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRangeHelper(a, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private int arrayRangeHelper(int[] a, int index, int min, int max) {
		if (a.length == index)
			return max - min;
		if (a[index] > max)
			max = a[index];
		if (a[index] < min)
			min = a[index];
		return arrayRangeHelper(a, index + 1, min, max);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		return isSortedHelper(nums, 0);
	}

	private boolean isSortedHelper(int[] nums, int index) {
		if (index == nums.length - 1)
			return true;
		else if (nums.length == 0)
			return true;
		else if (nums[index] > nums[index + 1])
			return false;

		return isSortedHelper(nums, index + 1);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return foundHelper(search, strs, 0);
	}

	private boolean foundHelper(String search, String[] strs, int index) {
		if (index == strs.length)
			return false;
		else if (search.equals(strs[index]))
			return true;
		return foundHelper(search, strs, index + 1);
	}
}
