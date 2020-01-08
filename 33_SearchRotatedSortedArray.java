public class Solution{
	 public int search(int[] nums, int target){
		 if (nums == null || nums.length == 0){
			 return -1;
		 }

		 int start = 0, end = nums.length - 1;
		 int mid = 0;
		 while (start <= end){
			 mid = start + (end - start)/2;
			 if (nums[mid] == target){
				 return mid;
			 }

			if (nums[start] <= nums[mid]){
				//Front-Half is Sorted
				if (target >= nums[start] && target < nums[mid]){
					end = mid - 1;
				}else{
					start = mid + 1;
				}
			}else{
				if (target <= nums[end] && target > nums[mid]){
					start = mid + 1;
				}else{
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}
