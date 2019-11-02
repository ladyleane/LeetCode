//Brute Force O(n^2)

class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
		for (int i = 0; i < height.length; i++){
			for (int j = i + 1; j < height.length; j++){
				maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return maxarea;
    }
}


//Two Pointer Approach
class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0, left = 0, right = height.length - 1;
		while(left < right){
			maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right]){
				left++;
			}
			else{
				right--;
			}
		}
		return maxarea;
    }
}
