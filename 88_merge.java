class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }
}


//Double pointers
class Solution{
	public void merge(int[] nums1, int m, int[] nums2, int n){
		int[] nums1_c = new int[m];
		int p1 = 0;
		int p2 = 0;

		int p = 0;

		while((p1 < m) && (p2 < n))
		nums1[p++] = (nums1_c[p1] < nums2[p2] ? nums1_c[p1++] : nums2[p2++]);
		if (p1 < m)
			System.arraycopy(nums1_c, p1, nums1, p1 + p2, m + n - p1 - p2);

		if (p2 < n)
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
	}
}


//
class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    // two get pointers for nums1 and nums2
    int p1 = m - 1;
    int p2 = n - 1;
    // set pointer for nums1
    int p = m + n - 1;

    // while there are still elements to compare
    while ((p1 >= 0) && (p2 >= 0))
      // compare two elements from nums1 and nums2
      // and add the largest one in nums1
      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

    // add missing elements from nums2
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
  }
}
