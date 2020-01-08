public class Solution{
	private int extremeInsertionIndex(int[] nums, int target, boolean left){
		int lo = 0;
		int hi = nums.length;

		while(lo < hi){
			int mid = lo + (hi - lo)/2;
			if (nums[mid] > target || (left && target == nums[mid])){
				hi = mid;
			}else{
				lo = mid + 1;
			}
		}
		return lo;
	}

	public int[] searchRange(int[] nums, int target){
		int[] targetRange = {-1, -1};
		int leftIndex = extremeInsertionIndex(nums, target, true);
		if (leftIndex == nums.length || nums[leftIndex] != target){
			return targetRange;
		}

		targetRange[0] = leftIndex;
		targetRange[1] = extremeInsertionIndex(nums, target, false) - 1;

		return targetRange;
	}
}
