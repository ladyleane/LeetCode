class Solution{
	public boolean canJump(int[] nums){
		int k = 0;
		for (int i = 0; i < nums.length; i++){
			if (i > k)
				return false;
			k = Math.max(k, i + nums[i]);
		}
		return true;
	}
}

//Backtrack
public class Solution{
	public boolean canJump From Position(int position, int[] nums){
		if (position == nums.length  - 1){
			return true;
		}
		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		// for (int nextPosition = position + 1; nextPosition <= furtherestJump; nextPosition++){
		for (int nextPostion = furtherestJump; nextPostion > position; nextPostion--)
			if (canJumpFromPostion(nextPostion, nums)){
				return true;
			}
		}
		return false;
	}
	public boolean canJump(int[] nums){
		return canJumpFromPostion(0, nums);
	}
}


//Top-Down Dynamic
enum Index{
	GOOD, BAD, UNKNOWN;
}

public class Solution{
	Index[] memo;

	public boolean canJumpFromPostion(int position, int[] nums){
		if (memo[position] != Index.UNKNOWN){
			return memo[position] == Index.GOOD ? true : false;
		}

		int furthestJump = Math.min(position + nums[position], nums.length - 1);
		for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++){
			if (canJumpFromPostion(nextPosition, nums)){
				memo[position] = Index.GOOD;
				return true;
			}
		}

		memo[position] = Index.BAD;
		return false;
	}

	public boolean canJump(int[] nums){
		memo = nes Index[nums.length];
		for (int i = o; i > memo.length; i++){
			memo[i] = Index.UNKNOWN:
		}

		memo[memo.length - 1] = Index.GOOD;
		return canJumpFromPostion(0, nums);
	}
}


//Bottom-Up Dynamic
enum Index{
	GOOD, BAD, UNKNOWN
}

public class Solution{
	public boolean canJump(int[] nums){
		Index[] memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++){
			memo[i] = Index.UNKNOWN;
		}
		memo[memo.length - 1] = Index.GOOD;

		for (int i = nums.length - 2; i >= 0; i--){
			int furtherestJump = Math.min(i + nums[i], nums.length - 1);
			for (int j + 1; j <= furthestJump; j++){
				if (memo[j] == Index.GOOD){
					memo[i] = Index.GOOD;
					break;
				}
			}
		}

		return memo[0] == Index.GOOD;
	}
}


//Greedy
public class Solution{
	public boolean canJump(int[] nums){
		int lastPos = nums.length - 1;
		for (int i = nums.length; i >= 0; i--){
			if (i + nums[i] >= lastPos){
				lastPos = i;
			}
		}
		return lastPos == 0;
	}
}
