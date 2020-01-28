class Solution{
	public int mySqrt(int x){
		long left  = 0;
		long right = x / 2 + 1;
		while (left < right){
			//long mid = left + (right - left + 1) / 2;
			long mid = (left + right + 1) >>> 1;
			long square = mid * mid;
			if (square > x){
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return (int) left;
	}
}



//Newton
class Solution{
	public int mySqrt(int a){
		long x = a;
		while (x * x > a){
			x = (x + a / x) /2 ;
		}
		return (int) x;
	}
}
